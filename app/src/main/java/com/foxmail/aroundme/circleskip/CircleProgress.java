package com.foxmail.aroundme.circleskip;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gzl on 1/11/17.
 *
 * 自定义圆形进度条
 *
 * 注意在XML中需要将宽高设置相同，不然会报错
 *
 * 圆形进度条由一个环形＋一个内部圆以及内部圆的字体组成
 * 他们的半径都是由整个控件的宽和高控制，所以没有溢出情况
 *
 * 进度滚动来自于属性动画，这样看起来很平滑
 */

public class CircleProgress extends View {

    //内圆画笔
    private Paint mCirclePaint;
    // 画圆环的画笔
    private Paint mRingPaint;
    // 画字体的画笔
    private Paint mTextPaint;

    // 内圆颜色
    private int mCircleColor = Color.BLACK;
    // 内圆半径
    private float mCircleRadius = 30;

    // 圆环颜色
    private int mRingColor = Color.parseColor("#FF8800");
    // 圆环宽度
    private float mRingWidth = 2;
    // 圆环半径
    private float mRingRadius;

    //字体颜色
    private int mTextColor = Color.parseColor("#FFFFFF");
    //字体内容
    private String mText = "Skip";
    //字体大小
    private float mTextSize = 14;
    // 字的长度
    private float mTxtWidth;
    // 字的高度
    private float mTxtHeight;

    // 圆心x坐标
    private float mXCenter;
    // 圆心y坐标
    private float mYCenter;

    // 总进度
    private int mTotalProgress = 100;
    // 当前进度
    private float mProgress = 0;

    private int mStillTime = 0;

    private IOnLoadingComplete iOnLoadingComplete;


    public CircleProgress(Context context) {
        this(context, null);
    }

    public CircleProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(context, attrs, defStyleAttr);
        initPaint();

        setAnimation(0,100);
    }

    private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray typeArray = context.getTheme().obtainStyledAttributes(attrs,
                R.styleable.CircleProgress, 0, 0);
        mRingWidth = typeArray.getDimension(R.styleable.CircleProgress_ringWidth, mRingWidth);
        mCircleColor = typeArray.getColor(R.styleable.CircleProgress_circleColor, mCircleColor);
        mRingColor = typeArray.getColor(R.styleable.CircleProgress_ringColor, mRingColor);
        mTextColor = typeArray.getColor(R.styleable.CircleProgress_textColor, mTextColor);
        mText = typeArray.getString(R.styleable.CircleProgress_text);
        mTextSize = typeArray.getDimension(R.styleable.CircleProgress_textSize, mTextSize);
        mStillTime = typeArray.getInt(R.styleable.CircleProgress_stillTime, mStillTime);

        typeArray.recycle();
    }

    private void initPaint() {
        mCirclePaint = new Paint();
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(mCircleColor);
        mCirclePaint.setStrokeCap(Paint.Cap.ROUND);
        mCirclePaint.setStyle(Paint.Style.FILL);

        mRingPaint = new Paint();
        mRingPaint.setAntiAlias(true);
        mRingPaint.setColor(mRingColor);
        mRingPaint.setStrokeCap(Paint.Cap.ROUND);
        mRingPaint.setStyle(Paint.Style.STROKE);
        mRingPaint.setStrokeWidth(mRingWidth);

        mTextPaint = new Paint();
        mTextPaint.setAntiAlias(true);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setColor(mTextColor);
        mTextPaint.setTextSize(mTextSize);

        Paint.FontMetrics fm = mTextPaint.getFontMetrics();
        mTxtHeight = (int) Math.ceil(fm.descent - fm.ascent);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if(w != h) {
            throw new RuntimeException("width != height");
        }

        mXCenter = w / 2;
        mYCenter = h / 2;

        mRingRadius = w / 2 - mRingWidth;

        mCircleRadius = mRingRadius - mRingWidth / 2;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mXCenter, mYCenter, mCircleRadius, mCirclePaint);

        if(mTotalProgress > 0) {
            RectF rectF = new RectF();
            rectF.left = (mXCenter - mRingRadius);
            rectF.top = (mYCenter - mRingRadius);
            rectF.right = mRingRadius * 2 + (mXCenter - mRingRadius);
            rectF.bottom = mRingRadius * 2 + (mYCenter - mRingRadius);
            canvas.drawArc(rectF, -90, (mProgress / mTotalProgress) * 360, false, mRingPaint);

            mTxtWidth = mTextPaint.measureText(mText, 0, mText.length());

            canvas.drawText(mText, mXCenter - mTxtWidth / 2, mYCenter + mTxtHeight / 4, mTextPaint);

            if(mProgress == mTotalProgress) {
                if(iOnLoadingComplete != null) {
                    iOnLoadingComplete.OnLoadingComplete();
                }
            }
        }

    }

    private void setAnimation(float start, float stop) {
        if(mStillTime == 0) {
            throw new RuntimeException("Please set a value greater than 0 at XML");
        }
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(start, stop);
        valueAnimator.setDuration(mStillTime);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mProgress =  (Float) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();

    }

    /**
     * @param stillTime　动画持续时间
     */
    public void setmStillTime(int stillTime) {
        this.mStillTime = stillTime;
    }

    public void setOnLoadingComplete(IOnLoadingComplete iOnLoadingComplete) {
        this.iOnLoadingComplete = iOnLoadingComplete;
    }

    /**
     * 加载完成接口
     */
    public interface IOnLoadingComplete{
        void OnLoadingComplete();
    }
}
