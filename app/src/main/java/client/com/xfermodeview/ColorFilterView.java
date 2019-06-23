package client.com.xfermodeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ColorFilterView extends View {
    private Paint mPaint;
    private Bitmap mBitmap;
    public ColorFilterView(Context context) {
        super(context);
        mPaint=new Paint();
        mBitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.girl);
    }

    public ColorFilterView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public ColorFilterView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * R' = R * mul.R / 0xff + add.R
         * G' = G * mul.G / 0xff + add.G
         * B' = B * mul.B / 0xff + add.B
         */
        //将红色去除掉
//        LightingColorFilter lighting=new LightingColorFilter(0x00ffff,0x000000);
//        mPaint.setColorFilter(lighting);
//        canvas.drawBitmap(mBitmap,0,0,mPaint);
        //原始图片效果
//        LightingColorFilter lighting=new LightingColorFilter(0xffffff,0x000000);
//        mPaint.setColorFilter(lighting);
//        canvas.drawBitmap(mBitmap,0,0,mPaint);
        //绿色更亮
//        LightingColorFilter lightingColorFilter=new LightingColorFilter(0xffffff,0x003000);
//        mPaint.setColorFilter(lightingColorFilter);
//        canvas.drawBitmap(mBitmap,0,0,mPaint);

//        PorterDuffColorFilter porterDuffColorFilter=new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN);
//        mPaint.setColorFilter(porterDuffColorFilter);
//        canvas.drawBitmap(mBitmap,100,0,mPaint);

        float[] colorMatrix={
          2,0,0,0,0,//red
          0,1,0,0,0, //green
          0,0,1,0,0, //blue
          0,0,0,1,0, //alpha
        };

        ColorMatrix cm=new ColorMatrix();
//        cm.setScale(1,2,1,1);
        //饱和度调节 0--无色彩（黑白图片）1--默认效果 >1饱和度加强
//        cm.setSaturation(2);
       //红色值旋转45度
        cm.setRotate(0,45);
        ColorMatrixColorFilter colorMatrixColorFilter=new ColorMatrixColorFilter(cm);
        mPaint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(mBitmap,100,0,mPaint);
    }
}
