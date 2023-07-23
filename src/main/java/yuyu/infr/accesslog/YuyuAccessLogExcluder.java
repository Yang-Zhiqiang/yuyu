package yuyu.infr.accesslog;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import jp.co.slcs.swak.core.accesslog.AccessLogExcluder;
import jp.co.slcs.swak.core.logger.LoggerFactory;
import jp.co.slcs.swak.core.resource.ConfigFile;

import org.slf4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.common.base.Strings;

/**
 * アクセスログ出力除外判定<br />
 */
public class YuyuAccessLogExcluder implements AccessLogExcluder {

    private static Logger logger = LoggerFactory.getLogger(YuyuAccessLogExcluder.class);

    private static List<YuyuAccessLogExcludeDef> excludeDefList;

    @Override
    public boolean isExclude() {
        return isExclude(null);
    }

    @Override
    public boolean isExclude(String propName) {

        this.load();

        for (YuyuAccessLogExcludeDef def : excludeDefList) {
            if (this.isMatch(def, propName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatch(YuyuAccessLogExcludeDef def, String propName) {

        int match = 0;
        int unmatch = 0;

        if (!Strings.isNullOrEmpty(def.getSubsystemId())) {
            if (def.getSubsystemId().equals(YuyuAccessLogProp.SubsystemId.get())) {
                match++;
            } else {
                unmatch++;
            }
        }
        if (!Strings.isNullOrEmpty(def.getCategoryId())) {
            if (def.getCategoryId().equals(YuyuAccessLogProp.CategoryId.get())) {
                match++;
            } else {
                unmatch++;
            }
        }
        if (!Strings.isNullOrEmpty(def.getKinouId())) {
            if (def.getKinouId().equals(YuyuAccessLogProp.KinouId.get())) {
                match++;
            } else {
                unmatch++;
            }
        }
        if (!Strings.isNullOrEmpty(def.getPropName())) {
            if (def.getPropName().equals(propName)) {
                match++;
            } else {
                unmatch++;
            }
        }

        if (match > 0 && unmatch == 0) {
            return true;
        }
        return false;
    }

    @SuppressWarnings("resource")
    private void load() {

        if (excludeDefList != null) {
            return;
        }

        excludeDefList = new ArrayList<YuyuAccessLogExcludeDef>();

        InputStream in = ConfigFile.getConfigFileStream("swak-accesslog-config.xml");

        try {
            XPath xpath = XPathFactory.newInstance().newXPath();
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in);
            Node node = (Node)xpath.evaluate("/configuration/accesslog", doc, XPathConstants.NODE);
            NodeList nodeList = (NodeList)xpath.evaluate("exclude", node, XPathConstants.NODESET);

            if (nodeList != null) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    YuyuAccessLogExcludeDef def = new YuyuAccessLogExcludeDef();
                    def.setSubsystemId((String)xpath.evaluate("@subsystemid", nodeList.item(i), XPathConstants.STRING));
                    def.setCategoryId((String)xpath.evaluate("@categoryid", nodeList.item(i), XPathConstants.STRING));
                    def.setKinouId((String)xpath.evaluate("@kinouid", nodeList.item(i), XPathConstants.STRING));
                    def.setPropName((String)xpath.evaluate("@propname", nodeList.item(i), XPathConstants.STRING));
                    excludeDefList.add(def);

                    logger.debug("◇ swak-accesslog-config.xml <configuration><accesslog><exclude> ({})", i + 1);
                    if (!Strings.isNullOrEmpty(def.getSubsystemId())) {
                        logger.debug("｜  subsystemid = {}", def.getSubsystemId());
                    }
                    if (!Strings.isNullOrEmpty(def.getCategoryId())) {
                        logger.debug("｜  categoryid = {}", def.getCategoryId());
                    }
                    if (!Strings.isNullOrEmpty(def.getKinouId())) {
                        logger.debug("｜  kinouid = {}", def.getKinouId());
                    }
                    if (!Strings.isNullOrEmpty(def.getPropName())) {
                        logger.debug("｜  propname = {}", def.getPropName());
                    }
                    logger.debug("◇ swak-accesslog-config.xml </configuration></accesslog></exclude> ({})", i + 1);
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);

        } catch (SAXException e) {
            throw new RuntimeException(e);

        } catch (IOException e) {
            throw new RuntimeException(e);

        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);

        } finally {
            try {
                in.close();
            } catch (IOException e) {
            }
        }
    }

}
