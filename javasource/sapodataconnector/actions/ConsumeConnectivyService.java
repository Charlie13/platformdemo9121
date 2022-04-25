// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package sapodataconnector.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import sapodataconnector.connectivity.ProxyInformation;
import sapodataconnector.connectivity.ProxyInformationFactory;
import sapodataconnector.connectivity.SAPProxyInformationProvider;
import sapodataconnector.proxies.ConnectivityInfo;

public class ConsumeConnectivyService extends CustomJavaAction<IMendixObject>
{
	public ConsumeConnectivyService(IContext context)
	{
		super(context);
	}

	@java.lang.Override
	public IMendixObject executeAction() throws Exception
	{
		// BEGIN USER CODE
		try {
			ProxyInformation proxyInfo = ProxyInformationFactory.getProxyInformation(getContext());
			
			ConnectivityInfo result = new ConnectivityInfo(getContext());
			result.setProxyHost(proxyInfo.getProxyHost());
			result.setProxyPort(proxyInfo.getProxyPort());
			result.setSapConnectivityProxyCredentials(proxyInfo.getProxyCredentials());
			result.setSapConnectivityAuthentication(proxyInfo.getRequiredHeaders().get(SAPProxyInformationProvider.SAP_CONNECTIVITY_AUTHENTICATION));
			
			return result.getMendixObject();
		}catch(Exception e) {
			throw new RuntimeException("Not Connectivity Service binding found to the application environment", e);
		}
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "ConsumeConnectivyService";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
