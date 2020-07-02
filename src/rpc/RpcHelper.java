package rpc;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

public class RpcHelper {
		public static void writeJsonObject(HttpServletResponse response, JSONObject obj) {
			try {
				response.setContentType("application/json");
				response.addHeader("Access-Control-Allow-Origin", "*"); // "*" 表示允许任何人发request
				PrintWriter out = response.getWriter();
				out.print(obj);
				out.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		
		public static void writeJsonArray(HttpServletResponse response, JSONArray array) {
			try {
			    response.setContentType("application/json");
				response.addHeader("Access-Control-All ow-Origin", "*");
				PrintWriter out = response.getWriter();
				out.print(array);
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static JSONObject readJsonObject(HttpServletRequest request) {
			// get favorite items request 的recall: JSONObject
			//create a new function in RpcHelper.java to parse HTTP request body. Imagine the input HTTP request looks like:

			//{
			//    user_id = “1111”,
			//    favorite = [
			//        “abcd”,
			//        “efgh”,
			//    ]
			//}


			StringBuilder sb = new StringBuilder();
			try {
				BufferedReader reader = request.getReader();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				reader.close();
				return new JSONObject(sb.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;


		}

}
