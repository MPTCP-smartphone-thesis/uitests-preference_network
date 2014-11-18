package preference_network;

import utils.Utils;

import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class LaunchSettings extends UiAutomatorTestCase {

	private static String ID_SHAZ_TAGGING = "com.shazam.android:id/tagging_place_holder";
	private static String ID_SHAZ_NEWS_FEED = "com.shazam.android:id/news_feed_list";


	public void testDemo() throws UiObjectNotFoundException {
		assertTrue("OOOOOpps",
				Utils.openApp(this, "Settings", "com.android.settings"));

		sleep(2000);

		Utils.click(new UiObject(
				new UiSelector().className("android.widget.ListView").instance(0).childSelector(
						new UiSelector()
						.className("android.widget.LinearLayout")
.instance(6))));
		
		sleep(2000);

		Utils.click(new UiObject(new UiSelector()
.className(
				"android.widget.ListView")
				.childSelector(
						new UiSelector().className(
"android.widget.LinearLayout")
						.instance(8))));

		sleep(2000);

		Utils.click(new UiObject(new UiSelector()
				.className("android.widget.ListView")
				.instance(0)
				.childSelector(
						new UiSelector().className(
								"android.widget.LinearLayout").instance(4))));

		sleep(2000);

		String stringValue = getParams().getString("network-status");

		Utils.click(new UiObject(new UiSelector().textContains(stringValue
				.toLowerCase())));

		// Utils.click(Utils.getObjectWithClassName("android.widget.LinearLayout",
		// 4));

	}

}