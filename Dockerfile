FROM payara/micro:5.181
COPY target/hello-javaee8.war /opt/payara/deployments

# FROM payara/server-full:5.181
# COPY target/hello-javaee8.war $DEPLOY_DIR
