package zzz.test;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class HttpClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//			executeTestScenario();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private static void executeTestScenario() throws Exception {
		final HttpClient httpClient = new HttpClient();
		
		final List<NameValuePair> loginRequestParams = new LinkedList<NameValuePair>();
		loginRequestParams.add(new NameValuePair("username", "admin"));
		loginRequestParams.add(new NameValuePair("passwd", "admin"));
		
		{
			final GetMethod fetchLoginPageRequest = new GetMethod("http://localhost/joomla/administrator/");
			final int response = httpClient.executeMethod(fetchLoginPageRequest);
			System.out.println(response);
			if (response != 200) {
				return;
			}
			final HtmlCleaner cleaner = new HtmlCleaner();
			final TagNode loginPage = cleaner.clean(fetchLoginPageRequest.getResponseBodyAsStream());
			for (final Object node : loginPage.evaluateXPath("//form[@id='form-login']//input[@type='hidden']")) {
				final TagNode hiddenField = (TagNode) node;
				loginRequestParams.add(new NameValuePair(hiddenField.getAttributeByName("name"), hiddenField.getAttributeByName("value")));
			}
						
		}
		
		System.out.println();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println();
		
		{
			final PostMethod loginRequest = new PostMethod("http://localhost/joomla/administrator/index.php");
			loginRequest.setRequestBody(loginRequestParams.toArray(new NameValuePair[loginRequestParams.size()]));
			final int response = httpClient.executeMethod(loginRequest);
			System.out.println("POST login: " + response);
			if (response == 303) {
				System.out.println(loginRequest.getResponseHeaders("Location")[0].getValue());
			}
		}
		
		System.out.println();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println();
		
		final List<NameValuePair> installRequestParams = new LinkedList<NameValuePair>();
		installRequestParams.add(new NameValuePair("installtype", "folder"));
		installRequestParams.add(new NameValuePair("install_directory", "C:\\Users\\schmeedy\\temp\\joomla-extensions\\com_helloworld"));
		installRequestParams.add(new NameValuePair("task", "install.install"));

		{
			final GetMethod getMethod = new GetMethod("http://localhost/joomla/administrator/index.php?option=com_installer");
			final int response = httpClient.executeMethod(getMethod);
			System.out.println("GET installer page: " + response);
			final HtmlCleaner cleaner = new HtmlCleaner();
			final TagNode installPage = cleaner.clean(getMethod.getResponseBodyAsStream());
			final Object[] result = installPage.evaluateXPath("//form[@id='adminForm']//input[@type='hidden'][@value='1']");
			if (result.length == 1) {
				installRequestParams.add(new NameValuePair(((TagNode)result[0]).getAttributeByName("name"), "1"));
			}
		}
		
		System.out.println();
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		System.out.println();
		
		{
			final PostMethod installRequest = new PostMethod("http://localhost/joomla/administrator/index.php?option=com_installer&amp;view=install");
			installRequest.setRequestBody(installRequestParams.toArray(new NameValuePair[installRequestParams.size()]));
			final int response = httpClient.executeMethod(installRequest);
			System.out.println("POST install request: " + response);
			if (response == 303) {
				final String redirectUrl = installRequest.getResponseHeader("Location").getValue();
				System.out.println(redirectUrl);
				
				System.out.println();
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				System.out.println();
				
				final GetMethod fetchInstallReport = new GetMethod(redirectUrl);
				final int reportResponse = httpClient.executeMethod(fetchInstallReport);
				System.out.println("GET install report: " + reportResponse);
				System.out.println(fetchInstallReport.getResponseBodyAsString());
			} else if (response == 200) {
				System.out.println(installRequest.getResponseBodyAsString());
			}
		}
	}

}
