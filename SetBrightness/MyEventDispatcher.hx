package;

import flash.events.Event;

class MyEventDispatcher extends Event
{
    public static inline var PHOTO_SELECTED = "album_photo_selected";

    public var imagePath(default, null) : String;

    public function new(type:String, imgPath:String = "")
    {
		imagePath = imgPath;

        super(type, true, true);
		
		//trace("I got image path "+imagePath);
    }

	public override function clone() : Event
    {
		return new MyEventDispatcher(type, imagePath);
	}

	public override function toString() : String
    {
        var s = "[MyEventDispatcher type=" + type;
            s += " imagePath=" + imagePath;
			s += "]";
        return s;
	}
}