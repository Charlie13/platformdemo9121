// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package sapodataconnector.actions;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import com.mendix.core.Core;
import com.mendix.logging.ILogNode;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import sapodataconnector.proxies.OdataObject;
import sapodataconnector.proxies.constants.Constants;
import sapodataconnector.utils.ODataClientBuilder;
import sapodataconnector.utils.ODataRequestBuilder;
import sapodataconnector.utils.ODataResponseHandler;
import sapodataconnector.utils.ODataTypeChecker;
import sapodataconnector.utils.ToMendixSerializer;

public class GetList extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private java.lang.String responseType;
	private IMendixObject __destination;
	private sapodataconnector.proxies.Destination destination;
	private java.lang.String query;
	private IMendixObject __requestParameters;
	private sapodataconnector.proxies.RequestParams requestParameters;
	private IMendixObject __parent;
	private sapodataconnector.proxies.OdataObject parent;
	private java.lang.String parentAssociationName;
	private IMendixObject __resultInfo;
	private sapodataconnector.proxies.ResultInfo resultInfo;

	public GetList(IContext context, java.lang.String responseType, IMendixObject destination, java.lang.String query, IMendixObject requestParameters, IMendixObject parent, java.lang.String parentAssociationName, IMendixObject resultInfo)
	{
		super(context);
		this.responseType = responseType;
		this.__destination = destination;
		this.query = query;
		this.__requestParameters = requestParameters;
		this.__parent = parent;
		this.parentAssociationName = parentAssociationName;
		this.__resultInfo = resultInfo;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		this.destination = this.__destination == null ? null : sapodataconnector.proxies.Destination.initialize(getContext(), __destination);

		this.requestParameters = this.__requestParameters == null ? null : sapodataconnector.proxies.RequestParams.initialize(getContext(), __requestParameters);

		this.parent = this.__parent == null ? null : sapodataconnector.proxies.OdataObject.initialize(getContext(), __parent);

		this.resultInfo = this.__resultInfo == null ? null : sapodataconnector.proxies.ResultInfo.initialize(getContext(), __resultInfo);

		// BEGIN USER CODE
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug(new StringBuilder(getContext().getSession().getId().toString())
					.append("|GET|List, query: ")
					.append(query)
					.toString());
		}

		ODataTypeChecker.checkDescendantOf(Core.getMetaObject(responseType), OdataObject.entityName);
		String response = null;

		if(destination != null) {
			LOGGER.info("GetList:: Destination found, retriving list.");
			final HttpGet httpGet = ODataRequestBuilder.builder()
					.get(destination, query)
					.setContext(getContext())
					.fetchCSRFToken()
					.setRequestHeader(requestParameters)
					.build();

			try (final CloseableHttpClient httpClient = ODataClientBuilder.builder()
					.setContext(getContext())
					.setRequestParameters(requestParameters)
					.setDestination(destination)
					.build()) {

				response = httpClient.execute(httpGet, new ODataResponseHandler("GET", LOGGER, getContext()));
			}
		}
		else { 
			LOGGER.info("GetList:: Destination not found, retriving list using requestParameters");
			final HttpGet httpGet = ODataRequestBuilder.builder()
					.get(query)
					.setContext(getContext())
					.fetchCSRFToken()
					.setRequestHeader(requestParameters)
					.build();

			try (final CloseableHttpClient httpClient = ODataClientBuilder.builder()
					.setContext(getContext())
					.setRequestParameters(requestParameters)
					.build()) {

				response = httpClient.execute(httpGet, new ODataResponseHandler("GET", LOGGER, getContext()));
			}
			catch(Exception e) {
				LOGGER.error(e.getMessage());
				throw e;
			}
		}

		final List<IMendixObject> resultList = new ArrayList<>();
		ToMendixSerializer.createNewMendixObjectList(getContext(), responseType, resultList, resultInfo, response);
		ToMendixSerializer.setAssociationWithParent(getContext(), resultList, parent, parentAssociationName);
		
		return resultList;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 * @return a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "GetList";
	}

	// BEGIN EXTRA CODE
	private static final ILogNode LOGGER = Core.getLogger(Constants.getLogNode());
	// END EXTRA CODE
}
