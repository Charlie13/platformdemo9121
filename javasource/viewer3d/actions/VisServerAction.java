// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package viewer3d.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import viewer3d.actions.controller.MxController;

/**
 * Set up visualization server infrastructure.
 */
public class VisServerAction extends CustomJavaAction<java.lang.Void>
{
	private java.lang.String httpEndpoint;

	public VisServerAction(IContext context, java.lang.String httpEndpoint)
	{
		super(context);
		this.httpEndpoint = httpEndpoint;
	}

	@java.lang.Override
	public java.lang.Void executeAction() throws Exception
	{
		// BEGIN USER CODE
		HttpHandler.instance.addController(MxController.class);
		HttpHandler.register(httpEndpoint);
		// WebSocketHandler.register(webSocketEndpoint);
		return null;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "VisServerAction";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
