package;


import flash.events.MouseEvent;
import openfl.display.Bitmap;
import openfl.display.Sprite;
import openfl.display.BitmapData;
import lime.app.Future;

class Main extends Sprite {
	
	
	public function new () {
		
		super ();
		
		SetBrightness.Initialize();
		
		stage.addEventListener(MyEventDispatcher.PHOTO_SELECTED, HandlePhotoCaptured);

		addSpriteButton();
		
	}
	
	private function addSpriteButton():Void{
		var stageWidth:Float = stage.stageWidth;
		var stageHeight:Float = stage.stageHeight;
		var spr:Sprite = new Sprite();
		spr.graphics.beginFill(0x00ff00);
		spr.graphics.drawRoundRect( 0, stageHeight - 100, stageWidth, 100,5);
		spr.graphics.endFill();
		addChild(spr);
		// button for click
		spr.addEventListener(MouseEvent.MOUSE_UP, function(e:MouseEvent)
		{
			SetBrightness.openAlbum();
		});
		
		// may photo overlap button
		/*stage.addEventListener(MouseEvent.MOUSE_UP, function(e:MouseEvent)
		{
			SetBrightness.openAlbum();
		});*/
	}
	
	public function HandlePhotoCaptured(e:MyEventDispatcher) : Void
    {
			//trace("Selected file " + e.imagePath);
 
			var future:Future<BitmapData> = BitmapData.loadFromFile(e.imagePath);
			
			future.onComplete(function(bmd:BitmapData){
				var bd:BitmapData = future.value;

				var bmp:Bitmap = new Bitmap(bd);

				var spr:Sprite = new Sprite();
				spr.addChild(bmp);
				addChild(spr);			

			});


    }
	
}