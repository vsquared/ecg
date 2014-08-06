/*
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

// Uses Arduino sketch 'ECG_BlueSerial'

package com.blueserial;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class GraphView extends View
{
    private Paint paint;
    private Path path;
    private int availableWidth;
	private int availableHeight;
	int count;
	int counter;
	private int data;
    
    //float spacing = (float)0.5;
	//float spacing = (float)0.25;
    float spacing = (float)1.00;
    
    public GraphView(Context context)
    {
        this(context, null);
    }
    
    // This constructor is the player but all are necessary!!
    public GraphView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setBackgroundColor(Color.BLUE);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setStyle(Paint.Style.STROKE);
		paint.setColor(Color.WHITE);
        paint.setStrokeWidth(3);
		paint.setStrokeCap(Paint.Cap.ROUND);
		paint.setStrokeJoin(Paint.Join.ROUND);
		   
		path = new Path();
        counter = 0;
    }
    
	public GraphView(Context context, AttributeSet attrs, int defStyle) {
	    super(context, attrs, defStyle);
	}
    
    @Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		availableWidth = getMeasuredWidth();
		availableHeight = getMeasuredHeight();
	}
    
	public void plotProcedure(int data) {
		this.data = data;
		if (counter > availableWidth/spacing) {counter = 0; path.reset(); }
		if (counter == 0) { path.moveTo(0, availableHeight - data);} else {
			path.lineTo( counter*spacing, availableHeight - data);
		}
		counter++;
		// Force redraw
		invalidate();
	}
    
    @Override
    public void onDraw(Canvas canvas)
    {
        paint.setTextSize(48);
		canvas.drawText(String.valueOf(data), availableWidth/10, availableHeight/10, paint);
		canvas.drawPath(path, paint);
    }
}
