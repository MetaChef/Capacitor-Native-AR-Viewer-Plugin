package nl.metachef.plugins.nativearviewer;

import com.getcapacitor.Plugin;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import android.content.Intent;
import android.net.Uri;

@CapacitorPlugin(name = "NativeARViewer")
public class NativeARViewerPlugin extends Plugin {

    @PluginMethod()
    public void openAR(PluginCall call) {
        // Extract parameters from JS call if any (e.g., model URL)
        String intentUrl = call.getString("intent");
        if (intentUrl == null) {
            call.reject("No intentUrl provided");
            return;
        }
        // Create the AR Scene Viewer intent
        Intent sceneViewerIntent = new Intent(Intent.ACTION_VIEW);
        Uri intentUri
                = Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
                        .appendQueryParameter("file", intentUrl)
                        .appendQueryParameter("mode", "ar_only")
                        .build();
        sceneViewerIntent.setData(intentUri);
        sceneViewerIntent.setPackage("com.google.ar.core");
        try {
            getActivity().startActivity(sceneViewerIntent);
            call.resolve();
        } catch (Exception e) {
            call.reject("Failed to launch AR viewer", e);
        }
    }
}
