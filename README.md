# CircleProgress


  ## 简介
  自定义圆形进度条

  圆形进度条由一个环形和一个内部圆以及内部圆的字体组成
  他们的半径都是由整个控件的宽和高控制，所以没有溢出情况

  进度滚动来自于属性动画，这样看起来很平滑

  ## 注意

  1. 在XML中需要将宽高设置相同，不然会报错
  2. 在XML中需要设置stillTime属性并且大于0,不然会报错

  ## 使用
  ```
  <com.foxmail.aroundme.circleskip.CircleProgress
          android:id="@+id/custom_progress"
          android:layout_width="45dp"
          android:layout_height="45dp"
          gzl:circleColor="#64000000"
          gzl:ringWidth="3dp"
          gzl:ringColor="#ff8800"
          gzl:textColor="#FFFFFF"
          gzl:text="Skip"
          gzl:textSize="14sp"
          gzl:stillTime="3000"
          />
```

  ## 属性介绍
  ```
          <attr name="circleColor" format="color" /><!--内圆颜色-->
          <attr name="ringWidth" format="dimension" /><!--圆环宽度-->
          <attr name="ringColor" format="color" /><!--圆环颜色-->
          <attr name="textColor" format="color|reference" /><!--字体颜色-->
          <attr name="text" format="string|reference" /><!--字体内容-->
          <attr name="textSize" format="dimension|reference" /><!--字体大小-->
          <attr name="stillTime" format="integer" /><!--持续时间-->
```


<img src="https://github.com/aroundone/GifRepository/blob/master/CircleProgress/CircleProgress.gif" width=360 height=640 />

