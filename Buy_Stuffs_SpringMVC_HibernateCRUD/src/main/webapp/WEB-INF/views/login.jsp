<HTML>
    <Head>
    </Head>
    <Body>
        <H1>LP</H1>
        <!-- method="post" is for making sure we don't pass the parameters in the URL -->
        <!-- In web.XML, we need to make sure to specify /login URI where this info is going -->
        <form method="get" action="logon">
            username <input type="text" name="uname"/> <Br>
            password <input type="text" name="pass"/>
            <!-- Make sure to use input type "Submit" instead of input type "Button" -->
            <input type="Submit" value="Submit">We can get rid of this text.</input>
    </form>
    </Body>
</HTML>

    <!-- 
        uname="Revat" && pass="xyz"

        String username - request.getParameter("uname");
        String password = request.getParameter("pass");

        These will go to LoginServlet which will extend HttpServlet

        Step 1: Info is sent from form
        Step 2: LoginServlet
        Step 3: request.getParameter
        Step 4: Print the info

        if (username equal to correct username) {
            RequestDispatcher request.dispatcher
        } else {
        response.forward (req, resp)
        }
     -->