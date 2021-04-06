


package bbs;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


/**
 * Example listener for context-related application events, which were
 * introduced in the 2.3 version of the Servlet API.  This listener
 * merely documents the occurrence of such events in the application log
 * associated with our servlet context.
 *
 * @author Craig R. McClanahan
 * @version $Revision: 1.1.1.1 $ $Date: 2002/08/27 13:16:53 $
 */

public final class testListener
    implements ServletContextListener,
	       HttpSessionAttributeListener, HttpSessionListener {


    // ----------------------------------------------------- Instance Variables


    /**
     * The servlet context with which we are associated.
     */
    private ServletContext context = null;


    // --------------------------------------------------------- Public Methods


    /**
     * Record the fact that a servlet context attribute was added.
     *
     * @param event The session attribute event
     */
    public void attributeAdded(HttpSessionBindingEvent event) {

	log("attributeAdded('" + event.getSession().getId() + "', '" +
	    event.getName() + "', '" + event.getValue() + "')");

    }


    /**
     * Record the fact that a servlet context attribute was removed.
     *
     * @param event The session attribute event
     */
    public void attributeRemoved(HttpSessionBindingEvent event) {

	log("attributeRemoved('" + event.getSession().getId() + "', '" +
	    event.getName() + "', '" + event.getValue() + "')");

    }


    /**
     * Record the fact that a servlet context attribute was replaced.
     *
     * @param event The session attribute event
     */
    public void attributeReplaced(HttpSessionBindingEvent event) {

	log("attributeReplaced('" + event.getSession().getId() + "', '" +
	    event.getName() + "', '" + event.getValue() + "')");

    }


    /**
     * Record the fact that this web application has been destroyed.
     *
     * @param event The servlet context event
     */
    public void contextDestroyed(ServletContextEvent event) {

	log("contextDestroyed()");
	this.context = null;

    }


    /**
     * Record the fact that this web application has been initialized.
     *
     * @param event The servlet context event
     */
    public void contextInitialized(ServletContextEvent event) {

	this.context = event.getServletContext();
	log("contextInitialized()");

    }


    /**
     * Record the fact that a session has been created.
     *
     * @param event The session event
     */
    public void sessionCreated(HttpSessionEvent event) {

	log("sessionCreated('" + event.getSession().getId() + "')");

    }


    /**
     * Record the fact that a session has been destroyed.
     *
     * @param event The session event
     */
    public void sessionDestroyed(HttpSessionEvent event) {

	log("sessionDestroyed('" + event.getSession().getId() + "')");

    }


    // -------------------------------------------------------- Private Methods


    /**
     * Log a message to the servlet context application log.
     *
     * @param message Message to be logged
     */
    private void log(String message) {

	if (context != null)
	    context.log("SessionListener: " + message);
	else
	    System.out.println("SessionListener: " + message);

    }


    /**
     * Log a message and associated exception to the servlet context
     * application log.
     *
     * @param message Message to be logged
     * @param throwable Exception to be logged
     */
    private void log(String message, Throwable throwable) {

	if (context != null)
	    context.log("SessionListener: " + message, throwable);
	else {
	    System.out.println("SessionListener: " + message);
	    throwable.printStackTrace(System.out);
	}

    }


}
