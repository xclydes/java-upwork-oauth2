/**
 * Copyright 2014 Upwork
 *
 * Licensed under the Upwork's API Terms of Use;
 * you may not use this file except in compliance with the Terms.
 * You may obtain a copy of the Terms at
 * 
 *    https://developers.upwork.com/api-tos.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.Upwork.api.Routers.Organization;

import com.Upwork.ClassPreamble;
import com.Upwork.api.OAuthClient;

import org.json.JSONException;
import org.json.JSONObject;

@ClassPreamble (
	author = "Maksym Novozhylov <mnovozhilov@upwork.com>",
	date = "6/4/2014",
	currentRevision = 1,
	lastModified = "6/4/2014",
	lastModifiedBy = "Maksym Novozhylov",
	reviewers = {"Yiota Tsakiri"}
)
public final class Companies {
	
	final static String ENTRY_POINT = "api";
	
	private OAuthClient oClient = null;

	public Companies(OAuthClient client) {
		oClient = client;
		oClient.setEntryPoint(ENTRY_POINT);
	}
	
	/** 
     * Get Companies Info
     *
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getList() throws JSONException {   
        return oClient.get("/hr/v2/companies");
    }   

    /** 
     * Get Specific Company
     *
     * @param   cmpReference Company reference
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getSpecific(String cmpReference) throws JSONException {   
        return oClient.get("/hr/v2/companies/" + cmpReference);
    }
    
    /**
     * Get Teams in Company
     *
     * @param   cmpReference Company reference
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getTeams(String cmpReference) throws JSONException {
        return oClient.get("/hr/v2/companies/" + cmpReference + "/teams");
    }

    /**
     * Get Users in Company
     *
     * @param   cmpReference Company reference
     * @throws	JSONException If error occurred
	 * @return	{@link JSONObject}
     */
    public JSONObject getUsers(String cmpReference) throws JSONException {
        return oClient.get("/hr/v2/companies/" + cmpReference + "/users");
    }

}
