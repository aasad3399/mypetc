#!/bin/bash
rm -rf /usr/share/tomcat/webapps/petclinic*
service tomcat start > /var/log/starttomcat.out 2>&1

