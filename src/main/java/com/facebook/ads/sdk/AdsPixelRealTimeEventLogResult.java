/**
 * Copyright (c) 2015-present, Facebook, Inc. All rights reserved.
 *
 * You are hereby granted a non-exclusive, worldwide, royalty-free license to
 * use, copy, modify, and distribute this software in source code or binary
 * form for use in connection with the web services and APIs provided by
 * Facebook.
 *
 * As with any software that integrates with the Facebook platform, your use
 * of this software is subject to the Facebook Developer Principles and
 * Policies [http://developers.facebook.com/policy/]. This copyright notice
 * shall be included in all copies or substantial portions of the software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 *
 */

package com.facebook.ads.sdk;

import java.io.File;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import com.facebook.ads.sdk.APIException.MalformedResponseException;

/**
 * This class is auto-generated.
 *
 * For any issues or feature requests related to this class, please let us know
 * on github and we'll fix in our codegen framework. We'll not be able to accept
 * pull request for this class.
 *
 */
public class AdsPixelRealTimeEventLogResult extends APINode {
  @SerializedName("data_json")
  private String mDataJson = null;
  @SerializedName("device_type")
  private String mDeviceType = null;
  @SerializedName("event")
  private String mEvent = null;
  @SerializedName("event_detection_method")
  private String mEventDetectionMethod = null;
  @SerializedName("matched_rule_conditions")
  private String mMatchedRuleConditions = null;
  @SerializedName("source_rule_condition")
  private String mSourceRuleCondition = null;
  @SerializedName("timestamp")
  private String mTimestamp = null;
  @SerializedName("url")
  private String mUrl = null;
  @SerializedName("id")
  private String mId = null;
  protected static Gson gson = null;

  public AdsPixelRealTimeEventLogResult() {
  }

  public String getId() {
    return getFieldId().toString();
  }
  public static AdsPixelRealTimeEventLogResult loadJSON(String json, APIContext context, String header) {
    AdsPixelRealTimeEventLogResult adsPixelRealTimeEventLogResult = getGson().fromJson(json, AdsPixelRealTimeEventLogResult.class);
    if (context.isDebug()) {
      JsonParser parser = new JsonParser();
      JsonElement o1 = parser.parse(json);
      JsonElement o2 = parser.parse(adsPixelRealTimeEventLogResult.toString());
      if (o1.getAsJsonObject().get("__fb_trace_id__") != null) {
        o2.getAsJsonObject().add("__fb_trace_id__", o1.getAsJsonObject().get("__fb_trace_id__"));
      }
      if (!o1.equals(o2)) {
        context.log("[Warning] When parsing response, object is not consistent with JSON:");
        context.log("[JSON]" + o1);
        context.log("[Object]" + o2);
      };
    }
    adsPixelRealTimeEventLogResult.context = context;
    adsPixelRealTimeEventLogResult.rawValue = json;
    adsPixelRealTimeEventLogResult.header = header;
    return adsPixelRealTimeEventLogResult;
  }

  public static APINodeList<AdsPixelRealTimeEventLogResult> parseResponse(String json, APIContext context, APIRequest request, String header) throws MalformedResponseException {
    APINodeList<AdsPixelRealTimeEventLogResult> adsPixelRealTimeEventLogResults = new APINodeList<AdsPixelRealTimeEventLogResult>(request, json, header);
    JsonArray arr;
    JsonObject obj;
    JsonParser parser = new JsonParser();
    Exception exception = null;
    try{
      JsonElement result = parser.parse(json);
      if (result.isJsonArray()) {
        // First, check if it's a pure JSON Array
        arr = result.getAsJsonArray();
        for (int i = 0; i < arr.size(); i++) {
          adsPixelRealTimeEventLogResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
        };
        return adsPixelRealTimeEventLogResults;
      } else if (result.isJsonObject()) {
        obj = result.getAsJsonObject();
        if (obj.has("data")) {
          if (obj.has("paging")) {
            JsonObject paging = obj.get("paging").getAsJsonObject();
            if (paging.has("cursors")) {
                JsonObject cursors = paging.get("cursors").getAsJsonObject();
                String before = cursors.has("before") ? cursors.get("before").getAsString() : null;
                String after = cursors.has("after") ? cursors.get("after").getAsString() : null;
                adsPixelRealTimeEventLogResults.setCursors(before, after);
            }
            String previous = paging.has("previous") ? paging.get("previous").getAsString() : null;
            String next = paging.has("next") ? paging.get("next").getAsString() : null;
            adsPixelRealTimeEventLogResults.setPaging(previous, next);
            if (context.hasAppSecret()) {
              adsPixelRealTimeEventLogResults.setAppSecret(context.getAppSecretProof());
            }
          }
          if (obj.get("data").isJsonArray()) {
            // Second, check if it's a JSON array with "data"
            arr = obj.get("data").getAsJsonArray();
            for (int i = 0; i < arr.size(); i++) {
              adsPixelRealTimeEventLogResults.add(loadJSON(arr.get(i).getAsJsonObject().toString(), context, header));
            };
          } else if (obj.get("data").isJsonObject()) {
            // Third, check if it's a JSON object with "data"
            obj = obj.get("data").getAsJsonObject();
            boolean isRedownload = false;
            for (String s : new String[]{"campaigns", "adsets", "ads"}) {
              if (obj.has(s)) {
                isRedownload = true;
                obj = obj.getAsJsonObject(s);
                for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
                  adsPixelRealTimeEventLogResults.add(loadJSON(entry.getValue().toString(), context, header));
                }
                break;
              }
            }
            if (!isRedownload) {
              adsPixelRealTimeEventLogResults.add(loadJSON(obj.toString(), context, header));
            }
          }
          return adsPixelRealTimeEventLogResults;
        } else if (obj.has("images")) {
          // Fourth, check if it's a map of image objects
          obj = obj.get("images").getAsJsonObject();
          for (Map.Entry<String, JsonElement> entry : obj.entrySet()) {
              adsPixelRealTimeEventLogResults.add(loadJSON(entry.getValue().toString(), context, header));
          }
          return adsPixelRealTimeEventLogResults;
        } else {
          // Fifth, check if it's an array of objects indexed by id
          boolean isIdIndexedArray = true;
          for (Map.Entry entry : obj.entrySet()) {
            String key = (String) entry.getKey();
            if (key.equals("__fb_trace_id__")) {
              continue;
            }
            JsonElement value = (JsonElement) entry.getValue();
            if (
              value != null &&
              value.isJsonObject() &&
              value.getAsJsonObject().has("id") &&
              value.getAsJsonObject().get("id") != null &&
              value.getAsJsonObject().get("id").getAsString().equals(key)
            ) {
              adsPixelRealTimeEventLogResults.add(loadJSON(value.toString(), context, header));
            } else {
              isIdIndexedArray = false;
              break;
            }
          }
          if (isIdIndexedArray) {
            return adsPixelRealTimeEventLogResults;
          }

          // Sixth, check if it's pure JsonObject
          adsPixelRealTimeEventLogResults.clear();
          adsPixelRealTimeEventLogResults.add(loadJSON(json, context, header));
          return adsPixelRealTimeEventLogResults;
        }
      }
    } catch (Exception e) {
      exception = e;
    }
    throw new MalformedResponseException(
      "Invalid response string: " + json,
      exception
    );
  }

  @Override
  public APIContext getContext() {
    return context;
  }

  @Override
  public void setContext(APIContext context) {
    this.context = context;
  }

  @Override
  public String toString() {
    return getGson().toJson(this);
  }


  public String getFieldDataJson() {
    return mDataJson;
  }

  public AdsPixelRealTimeEventLogResult setFieldDataJson(String value) {
    this.mDataJson = value;
    return this;
  }

  public String getFieldDeviceType() {
    return mDeviceType;
  }

  public AdsPixelRealTimeEventLogResult setFieldDeviceType(String value) {
    this.mDeviceType = value;
    return this;
  }

  public String getFieldEvent() {
    return mEvent;
  }

  public AdsPixelRealTimeEventLogResult setFieldEvent(String value) {
    this.mEvent = value;
    return this;
  }

  public String getFieldEventDetectionMethod() {
    return mEventDetectionMethod;
  }

  public AdsPixelRealTimeEventLogResult setFieldEventDetectionMethod(String value) {
    this.mEventDetectionMethod = value;
    return this;
  }

  public String getFieldMatchedRuleConditions() {
    return mMatchedRuleConditions;
  }

  public AdsPixelRealTimeEventLogResult setFieldMatchedRuleConditions(String value) {
    this.mMatchedRuleConditions = value;
    return this;
  }

  public String getFieldSourceRuleCondition() {
    return mSourceRuleCondition;
  }

  public AdsPixelRealTimeEventLogResult setFieldSourceRuleCondition(String value) {
    this.mSourceRuleCondition = value;
    return this;
  }

  public String getFieldTimestamp() {
    return mTimestamp;
  }

  public AdsPixelRealTimeEventLogResult setFieldTimestamp(String value) {
    this.mTimestamp = value;
    return this;
  }

  public String getFieldUrl() {
    return mUrl;
  }

  public AdsPixelRealTimeEventLogResult setFieldUrl(String value) {
    this.mUrl = value;
    return this;
  }

  public String getFieldId() {
    return mId;
  }

  public AdsPixelRealTimeEventLogResult setFieldId(String value) {
    this.mId = value;
    return this;
  }




  synchronized /*package*/ static Gson getGson() {
    if (gson != null) {
      return gson;
    } else {
      gson = new GsonBuilder()
        .excludeFieldsWithModifiers(Modifier.STATIC)
        .excludeFieldsWithModifiers(Modifier.PROTECTED)
        .disableHtmlEscaping()
        .create();
    }
    return gson;
  }

  public AdsPixelRealTimeEventLogResult copyFrom(AdsPixelRealTimeEventLogResult instance) {
    this.mDataJson = instance.mDataJson;
    this.mDeviceType = instance.mDeviceType;
    this.mEvent = instance.mEvent;
    this.mEventDetectionMethod = instance.mEventDetectionMethod;
    this.mMatchedRuleConditions = instance.mMatchedRuleConditions;
    this.mSourceRuleCondition = instance.mSourceRuleCondition;
    this.mTimestamp = instance.mTimestamp;
    this.mUrl = instance.mUrl;
    this.mId = instance.mId;
    this.context = instance.context;
    this.rawValue = instance.rawValue;
    return this;
  }

  public static APIRequest.ResponseParser<AdsPixelRealTimeEventLogResult> getParser() {
    return new APIRequest.ResponseParser<AdsPixelRealTimeEventLogResult>() {
      public APINodeList<AdsPixelRealTimeEventLogResult> parseResponse(String response, APIContext context, APIRequest<AdsPixelRealTimeEventLogResult> request, String header) throws MalformedResponseException {
        return AdsPixelRealTimeEventLogResult.parseResponse(response, context, request, header);
      }
    };
  }
}
