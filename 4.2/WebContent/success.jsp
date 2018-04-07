<%@ page language="java" import="java.util.*,org.great.action.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="Bean.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <link rel="stylesheet" href="css/theme.css" type="text/css" />
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<!--     登录成功，欢迎! -->
<%--     <% 	Emp user = (Emp)session.getAttribute("USER"); --%>
<!-- //     	out.print(user.getEmp_name()); -->
<%--     %>, --%>
<%--     <%=user.getEmp_name() %>, --%>
<%--     ${session.USER.emp_name }, --%>
<%--     ${session.USER.getEmp_name() } --%>
<!--     <a href="login.action?user.name=tologin">点击此处</a>返回登录页 <br> -->
    
    <div id='cssmenu'>
        <ul>
           <li><a href=''>Home</a>
              <ul>
                 <li><a href=''>Copter</a></li>
                 <li><a href=''>Plane</a></li>
                 <li><a href=''>Rover</a></li>
                 <li><a href=''>Sub</a></li>
                 <li><a href=''>AntennaTracker</a></li>
                 <li><a href=''>Mission Planner</a></li>
                 <li><a href=''>APM Planner 2</a></li>
                 <li><a href=''>Companion Computers</a></li>
                 <li><a href=''>Developer</a></li>
              </ul>
           </li>
           
           <li><a href=''>Downloads</a>
              <ul>
                <li><a href=''>Mission Planner</a></li>
                <li><a href=''>APM Planner 2</a></li>
                   <li><a title="Advanced User Tools" href="">Advanced User Tools</a></li>
                   <li><a title="Developer Tools" href="">Developer Tools</a></li>
                   <li><a title="Firmware" href="">Firmware</a></li>
                 <li><a href=''>Tutorial PDFs</a></li>
              </ul>
           </li>
           
           <li><a href='' />Community</a>
              <ul>
                 <li><a href=''>Support Forums</a></li>
                 <li><a href=''>Facebook</a></li>
                 <li><a href=''>Developer Chat (Gitter)</a></li>
                 <li><a href=''>Developer Voice Chat (Mumble)</a></li>
                 <li><a href=''>Developer Email (drones-discuss)</a></li>
                   <li><a title="Commercial Support" href="">Commercial Support</a></li>
                   <li><a title="Dev Team" href="">Development Team</a></li>
                   <li><a title="Training Centers" href="">UAS Training Centers</a></li>
              </ul>
           </li>
             <li><a title="Stores" href="">Stores</a></li>

             <li><a title="SWAG Shop" href="">SWAG</a></li>
           
                        <li><a title="About" href="">About</a>
               <ul>
                   <li><a title="Project News" href="">News</a></li>
                   <li><a title="History of ArduPilot" href="">History</a></li>
                   <li><a href=''>License</a></li>
                   <li><a href=''>Trademark</a></li>
                   <li><a title="Acknowledgments" href="">Acknowledgments</a></li>
                   <li><a title="Wiki Editing Guide" href="">Wiki Editing Guide</a></li>
               </ul>
             </li>
        </ul>
        
<style>
#jdlogo {
  top: 10px;
  right: 20px;
  position: absolute;
  color: #dddddd;
}
#jdlogo a:visited,
#jdlogo a:link {
  color: #9B59B6;
}
#jdlogo a:hover,
#jdlogo a:active {
  color: #CACACA;
}
</style>

<div id=jdlogo>
	欢迎！ ${session.USER.getEmp_name() }
<!-- 	<img src="Image/user.jpg"  alt="用户头像" height="30" width="30"/> -->
	<img src="<s:property value="'upload/' + userImage"/> " alt="图像无法显示" height="30" width="30"/>
	
</div>	
        
</div>

  <div class="wy-grid-for-nav">

    
    <nav data-toggle="wy-nav-shift" class="wy-nav-side">
      <div class="wy-side-nav-search">
          <a href="../index.html" class="icon icon-home"> 搜索内容</a>
          
<div role="search">
  <form id="rtd-search-form" class="wy-form" action="../search.html" method="get">
    <input type="text" name="q" placeholder="Search docs" />
    <input type="hidden" name="check_keywords" value="yes" />
    <input type="hidden" name="area" value="default" />
  </form>
</div>
        
        
        
</div>
 <script type="text/javascript">
//二级菜单部分
 function myClick1(node){
 	var bigDivNode = document.getElementById("bigDiv");
 	var divArr = bigDivNode.getElementsByTagName("div");//获取大Div下的所有子div集合
 	var tdNode = node.parentNode;
 	var arr = tdNode.getElementsByTagName("div");//获取当前点击的div元素
 	var divNode = arr[0];
 	divNode.className ="toctree-l1 current";
 	for (var i = 0; i < divArr.length; i++) {
 		if (arr[0] == divArr[i]) {
 			divNode.style.display = "block";
 		}else{
 			divArr[i].style.display = "none";
 		}
 	}
 }
</script>
      <div class="wy-menu wy-menu-vertical" data-spy="affix" role="navigation" aria-label="main navigation" id="bigDiv">
      <ul class="current">
		<li class="toctree-l1"><a class="reference internal" href="">上传文档</a>
			<div>
				<ul>
					<li class="toctree-l2"><a class="reference internal" href="">添加用户&amp;用户列表</a></li>
				</ul>
			</div>
		</li>
		<li class="toctree-l1"><a class="reference internal" href="2">查看文档</a>
		</li>
		<li class="toctree-l1 "><a class="current reference internal" href="">用户管理</a>
			<ul>
				<li class="toctree-l2"><a class="reference internal" href="">添加用户&amp;用户列表</a></li>
			</ul>
</li>

</ul>

          
        
        
        <!-- add paypal and dronecode logos -->
                <div style="margin: auto; padding-left:20px; padding-right:20px; width=100%">
        
        <hr />
        <form style="margin:auto;" action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
        <input type="hidden" name="cmd" value="_s-xclick" />
        <input type="hidden" name="hosted_button_id" value="BBF28AFAD58B2" />
        <input type="image" src="https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif" border="0" name="submit" title="点击赞助作者！" alt="哈哈" />
        </form>
        <br>
        <a href="http://ardupilot.org/copter/docs/common-donation.html">Individual</a>
        <a href="http://ardupilot.org/copter/docs/common-partners.html">Corporate</a>
        <a href="https://shop.ardupilot.org">SWAG Shop</a>

        <hr />
        </div>
        <!-- endadd paypal and dronecode logos -->
              
      </div>
      &nbsp;
    </nav>

    <section data-toggle="wy-nav-shift" class="wy-nav-content-wrap">

      
      <nav class="wy-nav-top" role="navigation" aria-label="top navigation">
        <i data-toggle="wy-nav-top" class="fa fa-bars"></i>
        <a href="../index.html">Copter</a>
      </nav>


      
<div class="wy-nav-content">
	 <iframe id="if1" src="1.JSP" frameborder="0" scrolling="auto" width=100% height=90%;></iframe>
        <div class="rst-content">
         


<div role="navigation" aria-label="breadcrumbs navigation">
  <ul class="wy-breadcrumbs">
    <li><a href="../index.html">文章</a> &raquo;</li>
      
    <li>欢迎页面</li>
      <li class="wy-breadcrumbs-aside">
                
          
            <a href="" class="fa fa-github"> Edit on GitHub</a>
          
        
      </li>
  </ul>
  <hr/>
</div>
				<div role="main" class="document" itemscope="itemscope">
					<div itemprop="articleBody">

						<div class="section" id="first-flight-with-copter">

							<span id="flying-arducopter"></span>
							<h1>
								欢迎登录!<a class="headerlink" href="#first-flight-with-copter"
									title="Permalink to this headline">¶</a>
							</h1>
							<p>This section covers the information you will need to know
								for your first flight and also some basic configuration to get
								your copter flying reasonably well.</p>
							<p>Some of this contents is also covered in this &#8220;first
								flight checks&#8221; video</p>
							<div>
								<table align="center" width="50%" border="1">
								<tr>
									<td>文件一</td>

									<td>下载</td>
								</tr>

								<tr>
									<td>文件二</td>

									<td>下载</td>
								</tr>
							</table>
							</div>
							<div
								style="padding-bottom: 56.250000%; padding-top: 30px; position: relative; width: 100%">
								<from
									action="${pageContext.request.contextPath }/system/PictureUser"
									method="post" enctype="multipart/from-data"> <input
									name="file123" type="file"> <input type="submit"
									value="上传"> </from>
							</div>
							<p>Please follow each of the links below.</p>
							<div class="toctree-wrapper compound">
								<ul>
									<li class="toctree-l1"><a class="reference internal"
										href="flight-modes.html">Flight Modes</a></li>
									<li class="toctree-l1"><a class="reference internal"
										href="prearm_safety_check.html">Pre-arm Safety Check</a></li>
									<li class="toctree-l1"><a class="reference internal"
										href="arming_the_motors.html">Arming and Disarming</a></li>
									<li class="toctree-l1"><a class="reference internal"
										href="ac_tipsfornewpilots.html">Getting Off the Ground –
											Tips for New Operators</a></li>
									<li class="toctree-l1"><a class="reference internal"
										href="basic-tuning.html">Basic Tuning</a></li>
									<li class="toctree-l1"><a class="reference internal"
										href="common-measuring-vibration.html">Measuring Vibration</a></li>
									<li class="toctree-l1"><a class="reference internal"
										href="ac_throttlemid.html">Setting Throttle Mid</a></li>
									<li class="toctree-l1"><a class="reference internal"
										href="autotrim.html">Save Trim &amp; Auto Trim</a></li>
									<li class="toctree-l1"><a class="reference internal"
										href="failsafe-landing-page.html">Failsafe Mechanisms</a></li>
									<li class="toctree-l1"><a class="reference internal"
										href="checklist.html">Pre-Flight Checklist</a></li>
								</ul>
							</div>
						</div>





					</div>
				</div>
<footer>
  
    <div class="rst-footer-buttons" role="navigation" aria-label="footer navigation">
      
        <a href="flight-modes.html" class="btn btn-neutral float-right" title="Flight Modes" accesskey="n">Next <span class="fa fa-arrow-circle-right"></span></a>
      
      
        <a href="set-motor-range.html" class="btn btn-neutral" title="Setting Motor Range" accesskey="p"><span class="fa fa-arrow-circle-left"></span> Previous</a>
      
    </div>
  

  <hr/>
  
  
  Questions, issues, and suggestions about this page can be raised on the <a href="http://discuss.ardupilot.org">forums</a>. Issues and suggestions may be posted on the forums or the <a href="https://github.com/ArduPilot/ardupilot_wiki/issues/new?title=First Flight with Copter&amp;body=[First Flight with Copter](http://ardupilot.org/copter/docs/flying-arducopter.html)%20-%20Describe%20the%20issue/suggestion%20and%20improve%20the%20title.%20Please%20keep%20a%20link%20to%20the%20original%20article%20if%20relevant.&amp;labels=docs">Github Issue Tracker</a>.
  <hr/>

  <div role="contentinfo">
    <p>
    <a style="float:right;" rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/"><img alt="Creative Commons License" style="border-width:0" src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a>
        &copy; Copyright 2016, ArduPilot Dev Team.

    </p>
  </div>
  


</footer>

        </div>

</div>

    </section>

  </div>
  


  

    <script type="text/javascript">
        var DOCUMENTATION_OPTIONS = {
            URL_ROOT:'../',
            VERSION:'',
            COLLAPSE_INDEX:false,
            FILE_SUFFIX:'.html',
            HAS_SOURCE:  true
        };
    </script>
      <script type="text/javascript" src="../_static/jquery.js"></script>
      <script type="text/javascript" src="../_static/underscore.js"></script>
      <script type="text/javascript" src="../_static/doctools.js"></script>

  

  
  
    <script type="text/javascript" src="../_static/js/theme.js"></script>
    <script type="text/javascript" src="../_static/js/menubar.js"></script>
  

  
  
  <script type="text/javascript">
      jQuery(function () {
          SphinxRtdTheme.StickyNav.enable();
      });
  </script>
   


<!-- Google Analytics -->
<!-- This is official ArduPilot analytics account -->
<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  _gaq.push(['_trackPageLoadTime']);
  _gaq.push(["_setSiteSpeedSampleRate", 0]);
  ga('create', 'UA-75650032-1', 'auto');
  ga('send', 'pageview');

</script>
  </body>
</html>
