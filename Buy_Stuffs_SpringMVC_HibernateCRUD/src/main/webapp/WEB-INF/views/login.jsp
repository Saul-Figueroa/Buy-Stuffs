<HTML>
    <Head>
    </Head>
    <Body>
        <H1>LP</H1>
        <!-- method="post" is for making sure we don't pass the parameters in the URL -->
        <!-- In web.XML, we need to make sure to specify /login URI where this info is going -->

        <form method="post" action="logon">
            Email <input type="text" name="email"/> <Br>
            Password <input type="text" name="password"/> <Br>
            <a href="forgot">Forgot password?</a> <Br>

            <!-- Make sure to use input type "Submit" instead of input type "Button" -->
            <input type="Submit" value="Submit">We can get rid of this text.</input>
    </form>
    </Body>
</HTML>

