/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2017 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.bottomsheet;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiC;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;
import org.appcelerator.titanium.util.TiConvert;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiCompositeLayout;
import org.appcelerator.titanium.view.TiCompositeLayout.LayoutArrangement;
import org.appcelerator.titanium.view.TiUIView;
import android.view.ViewGroup;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;

import java.util.Arrays;

import ti.bottomsheet.BottomSheet;

@Kroll.proxy(creatableInModule=TitaniumAndroidBottomSheetModule.class)
public class OptionDialogProxy extends KrollProxy
{
	// Standard Debugging variables
	private static final String LCAT = "OptionDialogProxy";
	private static final boolean DBG = TiConfig.LOGD;

	private String title;
	private TiViewProxy viewProxy;
	private String[] options;
	private String[] colors;
	private boolean cancelable;
	private int destructive;
	public static final String PROPERTY_VIEW = "view";

	// Handle creation options
	@Override
	public void handleCreationDict(KrollDict args)
	{
		super.handleCreationDict(args);


		if (args.containsKey(PROPERTY_VIEW)) {
			Object thisView = args.get(PROPERTY_VIEW);
			if (thisView != null && thisView instanceof TiViewProxy) {
				viewProxy = (TiViewProxy)thisView;
			} else {
				Log.e(LCAT, "[ERROR] Invalid type for view");
			}
		}

		title = args.getString("title");
		options = TiConvert.toStringArray((Object[]) args.get("options"));
		colors = TiConvert.toStringArray((Object[]) args.get("colors"));
		cancelable = args.optBoolean("cancelable", true);
		destructive = args.optInt("destructive", -1);
	}



	@Kroll.method
	public void show() {

 		Log.d(LCAT, "SHOW VIEW ");

		BottomSheet.Builder builder = new BottomSheet.Builder(TiApplication.getAppCurrentActivity());
		builder.setTitle(title);
		builder.setCancelable(cancelable);
	
		// TODO: Export all styles


		if (viewProxy == null){
			builder.setStyle(BottomSheet.Style.LIST);

			if (destructive > -1) {
				builder.setTitleColor(TiConvert.toColor("red"));
			}

			int i = 0;

			for (String option : options) {
				// TODO: Support image options
				// TODO: Support named dividers
				if (option != null) {

		           // builder.setItemColor(TiConvert.toColor(color));


					String thiscolor = colors[i];

			 	 	Log.w("thiscolor ", thiscolor);

					builder.addItem(i, option, TiConvert.toColor(thiscolor));
//					builder.setItemColorAtIndex(i,TiConvert.toColor(thiscolor));
//


					//thistItem.titleTextView.setTextColor(TiConvert.toColor(colors[i]));
				} else {
					builder.addDivider();
				}
				i++;
			}



			builder.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
					KrollDict event = new KrollDict();
					event.put("index", position);
	                event.put("cancel", false);
					fireEvent("click", event);
				}
			});

			builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
				@Override
				public void onCancel(DialogInterface dialog) {
					KrollDict event = new KrollDict();
					event.put("index", -1);
					event.put("cancel", true);
					fireEvent("click", event);
				}
			});
		}
		else {
			builder.setStyle(BottomSheet.Style.GRID);

			//thisCustomView.getActivity()

			//thisCustomView.setActivity(proxy.getActivity());
			//TiViewProxy customView = (TiViewProxy) thisCustomView;

		//	viewProxy.add(thisCustomView);


			TiUIView thisview = (viewProxy).getOrCreateView();
			thisview.getLayoutParams().autoFillsHeight = true;
			thisview.getLayoutParams().autoFillsWidth = true;

			builder.setView(thisview.getOuterView());


			// ViewGroup.LayoutParams params = layout.getLayoutParams();
			// params.height = customHeight;
			// layout.requestLayout();

			// if(thisCustomView instanceof TiViewProxy){
 		// 		Log.d(LCAT, "thisCustomView instanceof TiViewProxy ");

			// 	TiUIView thisview = thisCustomView.peekView();

			// 	if(thisview instanceof TiUIView){
	 	// 			Log.d(LCAT, "thisview instanceof TiUIView ");

	 	// 			View nativview = thisview.getNativeView();
			// 		if(nativview instanceof View){
		 // 				Log.d(LCAT, "nativview instanceof View ");

			// 			builder.setView(nativview);
			// 		}
			// 	}
			// }
			// else {
			// 	Log.d(LCAT, "thisCustomView is not instanceof TiViewProxy ");
			// }

			// TiUIView thisview = viewProxy.peekView();

			//  //View view = tiview.getOuterView();

			//  if (thisview != null){
 		// 		Log.d(LCAT, "thisview != null ");

			// 	View view = thisview.getNativeView();

			// 	 if(view != null){
	 	// 			Log.d(LCAT, "view != null ");

			// 		builder.setView(view);
			// 	 }
			// 	 else {
		 // 				Log.d(LCAT, "view == null ");
			// 	 }

			//  }
			//  else {
	 	// 			Log.d(LCAT, "thisview == null ");
			//  }

			 
		}

		builder.create().show();
	}
}
