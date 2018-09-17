package org.haxe.extension;


import android.app.Activity;
import android.content.res.AssetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import java.io.File;
import android.view.WindowManager;
import android.net.Uri;
import android.util.Log;
import java.io.InputStream;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import org.haxe.extension.extensionkit.HaxeCallback;
import org.haxe.extension.extensionkit.ImageUtils;


/* 
	You can use the Android Extension class in order to hook
	into the Android activity lifecycle. This is not required
	for standard Java code, this is designed for when you need
	deeper integration.
	
	You can access additional references from the Extension class,
	depending on your needs:
	
	- Extension.assetManager (android.content.res.AssetManager)
	- Extension.callbackHandler (android.os.Handler)
	- Extension.mainActivity (android.app.Activity)
	- Extension.mainContext (android.content.Context)
	- Extension.mainView (android.view.View)
	
	You can also make references to static or instance methods
	and properties on Java classes. These classes can be included 
	as single files using <java path="to/File.java" /> within your
	project, or use the full Android Library Project format (such
	as this example) in order to include your own AndroidManifest
	data, additional dependencies, etc.
	
	These are also optional, though this example shows a static
	function for performing a single task, like returning a value
	back to Haxe from Java.
*/
public class SetBrightness extends Extension {
	
	public static void LaunchChildActivity()
    {
//        MobileDevice.DisableBackButton();

        // launch activity
        
    }
	
//	@Override
 //   public void onResume()
//    {
 //       MobileDevice.EnableBackButton();
 //   } 
	
	public static int sampleMethod (int inputValue) {
		
		return inputValue * 100;
		
	}
	
	private static int RESULT_LOAD_PHOTO = 1;
	public static void openAlbum(){
		
		//Log.v("Najm","start openfl");
		
		Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

		Extension.mainActivity.startActivityForResult(i,RESULT_LOAD_PHOTO); 
		//Log.v("Najm","end openfl");
	}
	
	
	@Override
	public boolean onActivityResult(int requestCode, int resultCode, Intent data) {
		//Log.v("Najm","start activity trigger");
		if (requestCode == RESULT_LOAD_PHOTO){
			if(resultCode == Extension.mainActivity.RESULT_OK) {
			
				Uri selectedImage = data.getData();
				String[] filePathColumn = { MediaStore.Images.Media.DATA };

				Cursor cursor = Extension.mainActivity.getContentResolver().query(selectedImage,
						filePathColumn, null, null, null);
				cursor.moveToFirst();

				int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
				String photoPath = cursor.getString(columnIndex);
				cursor.close();
				//Log.v("Najm","mid activity trigger");
				HaxeCallback.DispatchEventToHaxe("MyEventDispatcher",
							new Object[] {
								"album_photo_selected",
								photoPath
							});
			//Log.v("Najm","end activity trigger");
			//Now you can do whatever you want with your inpustream, save it as file, upload to a server, decode a bitmap...
			}
			return false;
			
		}
		return super.onActivityResult(requestCode, resultCode, data);
	}
	
	/**
	 * Called when an activity you launched exits, giving you the requestCode 
	 * you started it with, the resultCode it returned, and any additional data 
	 * from it.
	 */
//	public boolean onActivityResult (int requestCode, int resultCode, Intent data) {
		
//		return true;
		
//	}

	/**
	 * Called when the activity receives th results for permission requests.
	 */
	public boolean onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {

		return true;

	}
	
	
	/**
	 * Called when the activity is starting.
	 */
	public void onCreate (Bundle savedInstanceState) {
		
		
		
	}
	
	
	/**
	 * Perform any final cleanup before an activity is destroyed.
	 */
	public void onDestroy () {
		
		
		
	}
	
	
	/**
	 * Called as part of the activity lifecycle when an activity is going into
	 * the background, but has not (yet) been killed.
	 */
	public void onPause () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onStop} when the current activity is being 
	 * re-displayed to the user (the user has navigated back to it).
	 */
	public void onRestart () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onRestart}, or {@link #onPause}, for your activity 
	 * to start interacting with the user.
	 */
	public void onResume () {
		
		
		
	}
	
	
	/**
	 * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when  
	 * the activity had been stopped, but is now again being displayed to the 
	 * user.
	 */
	public void onStart () {
		
		
		
	}
	
	
	/**
	 * Called when the activity is no longer visible to the user, because 
	 * another activity has been resumed and is covering this one. 
	 */
	public void onStop () {
		
		
		
	}
	
	
}