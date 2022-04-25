// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
import { Big } from "big.js";

// BEGIN EXTRA CODE
// END EXTRA CODE

/**
 * @returns {Promise.<boolean>}
 */
export async function DeviceIsConnected() {
	// BEGIN USER CODE
	const gattServer = window.gattServer;
	if(gattServer && gattServer.connected){
		return Promise.resolve(true);
	}
	return Promise.resolve(false);
	// END USER CODE
}
