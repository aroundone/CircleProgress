# CircleProgress


## 简介
  自定义圆形进度条

  圆形进度条由一个环形和一个内部圆以及内部圆的字体组成
  他们的半径都是由整个控件的宽和高控制，所以没有溢出情况
  
## 引入方式


   ```
   	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
   ```
   
   ```
  compile 'com.github.aroundone:CircleProgress:v1.2'
  
   ```

## 注意

  1. 在XML中需要将宽高设置相同，不然会抛出异常
  2. 在XML中需要设置stillTime属性并且大于0,不然会抛出异常

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

## 版本更新

###  v1.2
添加至JikPack

###  v1.1

添加两个属性direction(方向)和offset(偏移量)
```
        <!--方向-->
        <attr name="direction" format="integer" >
            <enum name="ClockWise" value="0"/>
            <enum name="CounterClockWise" value="1"/>
        </attr>
        <!--偏移量-->
        <attr name="offset" format="integer" >
            <enum name="InCrease" value="0"/>
            <enum name="DeCrease" value="1"/>
        </attr>
```
1. direction有两个选项Clockwise(顺时针)和Counterclockwise(逆时针)
2. offset有两个选项InCrease(增加)和DeCrease(减少)
可对应在XML中设置

### v1.0版
添加基本属性

```
circleColor  <!--内圆颜色-->
ringWidth    <!--圆环宽度-->
ringColor    <!--圆环颜色-->
textColor    <!--字体颜色-->
text         <!--字体内容-->
textSize     <!--字体大小-->
stillTime    <!--持续时间-->
```
