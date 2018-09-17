package;


import lime.system.CFFI;
import lime.system.JNI;
import extensionkit.ExtensionKit;

class SetBrightness {
	
	public static function Initialize() : Void
    {
        ExtensionKit.Initialize();

    }
	
	#if android
	private static var openFileJNI = JNI.createStaticMethod("org.haxe.extension.SetBrightness","openAlbum", "()V");	
	public static function openAlbum():Void{
//		trace('Extension Called : ');
		openFileJNI();
//		trace('After extension execution');
	}
	#end
	
	public static function sampleMethod (inputValue:Int):Int {
		
		#if android
		
		var resultJNI = setbrightness_sample_method_jni(inputValue);
		var resultNative = setbrightness_sample_method(inputValue);
		
		if (resultJNI != resultNative) {
			
			throw "Fuzzy math!";
			
		}
		
		return resultNative;
		
		#else
		
		return setbrightness_sample_method(inputValue);
		
		#end
		
	}
	
	
	private static var setbrightness_sample_method = CFFI.load ("setbrightness", "setbrightness_sample_method", 1);
	
	#if android
	private static var setbrightness_sample_method_jni = JNI.createStaticMethod ("org.haxe.extension.SetBrightness", "sampleMethod", "(I)I");
	#end
	
	
}