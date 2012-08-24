package ca.zgrs.clipper;


public class Clipper {
	
	 public static String ACTION_GET = "clipper.get";
	 public static String ACTION_GET_SHORT = "get";
	 public static String ACTION_SET = "clipper.set";
	 public static String ACTION_SET_SHORT = "set";
	
	 public static String EXTRA_TEXT = "text";
	
	 public static boolean isActionGet(final String action) {
		return ACTION_GET.equals(action) || ACTION_GET_SHORT.equals(action);
	 }
	
	public static boolean isActionSet(final String action) {
		return ACTION_SET.equals(action) || ACTION_SET_SHORT.equals(action);
	 }
}