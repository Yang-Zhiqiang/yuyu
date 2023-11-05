package yuyu.app.base.log.accesslogsyoukai;

import static yuyu.app.base.log.accesslogsyoukai.SeleniumAccessLogSyoukaiConstants.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.entity.AT_AccessLogSyousai;

public class SeleniumAccessLogSyoukaiDB {

    @Inject
    private BaseDomManager baseDomManager;

    @Transactional
    public void deleteTestB0004_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void deleteTestB0005_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void deleteTestB0006_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void createTestB0007_01(){

        AT_AccessLog accessLog = null;
        for( int idx = 0; idx < 350; idx++ ){

            accessLog = baseDomManager.getAccessLog(ALREADYLOGID + idx);
            if ( null == accessLog ) {

                accessLog = new AT_AccessLog();
                accessLog.setLogId(ALREADYLOGID + idx);
                accessLog.setTimeStamp(getSyoriTime(ALREADYLOGJIKOKU));
                accessLog.setSyoriUserId(ALREADYSYORIUSERID);
                accessLog.setIpAddress(ALREADYIPADDRESS);
                accessLog.setSessionId(ALREADYSESSIONID);
                accessLog.setLogKindCd(ALREADYLOGSYUBETUKBN);
                accessLog.setSubSystemId(ALREADYSUBSYSTEMID);
                accessLog.setCategoryId(ALREADYCATEGORYID);
                accessLog.setKinouId(ALREADYKINOUID);
                accessLog.setLogData(ALREADYLOGDATA + idx);
                accessLog.setSyousaiKensuu(ALREADYSYOUSAILOGKENSUU);

                baseDomManager.insert(accessLog);
            }
        }
    }

    @Transactional
    public void deleteTestB0007_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void createTestB0008_01(){

        AT_AccessLog accessLog = null;
        for( int idx = 0; idx < 350; idx++ ){

            accessLog = baseDomManager.getAccessLog(ALREADYLOGID + idx);
            if ( null == accessLog ) {

                accessLog = new AT_AccessLog();
                accessLog.setLogId(ALREADYLOGID + idx);
                accessLog.setTimeStamp(getSyoriTime(ALREADYLOGJIKOKU));
                accessLog.setSyoriUserId(ALREADYSYORIUSERID);
                accessLog.setIpAddress(ALREADYIPADDRESS);
                accessLog.setSessionId(ALREADYSESSIONID);
                accessLog.setLogKindCd(ALREADYLOGSYUBETUKBN);
                accessLog.setSubSystemId(ALREADYSUBSYSTEMID);
                accessLog.setCategoryId(ALREADYCATEGORYID);
                accessLog.setKinouId(ALREADYKINOUID);
                accessLog.setLogData(ALREADYLOGDATA + idx);
                accessLog.setSyousaiKensuu(ALREADYSYOUSAILOGKENSUU);

                baseDomManager.insert(accessLog);
            }
        }
    }

    @Transactional
    public void deleteTestB0008_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void createTestB0009_01(){

        AT_AccessLog accessLog = null;
        for( int idx = 0; idx < 350; idx++ ){

            accessLog = baseDomManager.getAccessLog(ALREADYLOGID + idx);
            if ( null == accessLog ) {

                accessLog = new AT_AccessLog();
                accessLog.setLogId(ALREADYLOGID + idx);
                accessLog.setTimeStamp(getSyoriTime(ALREADYLOGJIKOKU));
                accessLog.setSyoriUserId(ALREADYSYORIUSERID);
                accessLog.setIpAddress(ALREADYIPADDRESS);
                accessLog.setSessionId(ALREADYSESSIONID);
                accessLog.setLogKindCd(ALREADYLOGSYUBETUKBN);
                accessLog.setSubSystemId(ALREADYSUBSYSTEMID);
                accessLog.setCategoryId(ALREADYCATEGORYID);
                accessLog.setKinouId(ALREADYKINOUID);
                accessLog.setLogData(ALREADYLOGDATA + idx);
                accessLog.setSyousaiKensuu(ALREADYSYOUSAILOGKENSUU);

                baseDomManager.insert(accessLog);
            }
        }
    }

    @Transactional
    public void deleteTestB0009_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void createTestB0010_01(){

        AT_AccessLog accessLog = null;
        for( int idx = 0; idx < 350; idx++ ){

            accessLog = baseDomManager.getAccessLog(ALREADYLOGID + idx);
            if ( null == accessLog ) {

                accessLog = new AT_AccessLog();
                accessLog.setLogId(ALREADYLOGID + idx);
                accessLog.setTimeStamp(getSyoriTime(ALREADYLOGJIKOKU));
                accessLog.setSyoriUserId(ALREADYSYORIUSERID);
                accessLog.setIpAddress(ALREADYIPADDRESS);
                accessLog.setSessionId(ALREADYSESSIONID);
                accessLog.setLogKindCd(ALREADYLOGSYUBETUKBN);
                accessLog.setSubSystemId(ALREADYSUBSYSTEMID);
                accessLog.setCategoryId(ALREADYCATEGORYID);
                accessLog.setKinouId(ALREADYKINOUID);
                accessLog.setLogData(ALREADYLOGDATA + idx);
                accessLog.setSyousaiKensuu(ALREADYSYOUSAILOGKENSUU);

                baseDomManager.insert(accessLog);
            }
        }
    }

    @Transactional
    public void deleteTestB0010_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void createTestB0011_01(){

        AT_AccessLog accessLog = null;
        for( int idx = 0; idx < 350; idx++ ){

            accessLog = baseDomManager.getAccessLog(ALREADYLOGID + idx);
            if ( null == accessLog ) {

                accessLog = new AT_AccessLog();
                accessLog.setLogId(ALREADYLOGID + idx);
                accessLog.setTimeStamp(getSyoriTime(ALREADYLOGJIKOKU));
                accessLog.setSyoriUserId(ALREADYSYORIUSERID);
                accessLog.setIpAddress(ALREADYIPADDRESS);
                accessLog.setSessionId(ALREADYSESSIONID);
                accessLog.setLogKindCd(ALREADYLOGSYUBETUKBN);
                accessLog.setSubSystemId(ALREADYSUBSYSTEMID);
                accessLog.setCategoryId(ALREADYCATEGORYID);
                accessLog.setKinouId(ALREADYKINOUID);
                accessLog.setLogData(ALREADYLOGDATA + idx);
                accessLog.setSyousaiKensuu(ALREADYSYOUSAILOGKENSUU);

                baseDomManager.insert(accessLog);
            }
        }
    }

    @Transactional
    public void deleteTestB0011_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void deleteTestB0012_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void deleteTestB0013_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void createTestB0014_01(){

        AT_AccessLog accessLog = baseDomManager.getAccessLog(ALREADYLOGID);
        if ( null == accessLog ) {

            accessLog = new AT_AccessLog();

            accessLog.setLogId(ALREADYLOGID);
            accessLog.setTimeStamp(getSyoriTime(ALREADYLOGJIKOKU));
            accessLog.setSyoriUserId(ALREADYSYORIUSERID);
            accessLog.setIpAddress(ALREADYIPADDRESS);
            accessLog.setSessionId(ALREADYSESSIONID);
            accessLog.setLogKindCd(ALREADYLOGSYUBETUKBN);
            accessLog.setSubSystemId(ALREADYSUBSYSTEMID);
            accessLog.setCategoryId(ALREADYCATEGORYID);
            accessLog.setKinouId(ALREADYKINOUID);
            accessLog.setLogData(ALREADYLOGDATA);
            accessLog.setSyousaiKensuu(ALREADYSYOUSAILOGKENSUU);

            baseDomManager.insert(accessLog);
        }
    }

    @Transactional
    public void createTestB0014_02(){

        AT_AccessLog accessLog = baseDomManager.getAccessLog(ALREADYLOGID);
        if ( null != accessLog ) {

            AT_AccessLogSyousai accessLogSyousai = null;
            for ( int idx = 1; idx <= 350; idx++ ) {

                accessLogSyousai = accessLog.getAccessLogSyousai(idx);
                if ( null == accessLogSyousai ) {

                    accessLogSyousai = accessLog.createAccessLogSyousai();
                    accessLogSyousai.setSyousaiEdaNo((long) idx);
                    accessLogSyousai.setLogSyousaiData(ALREADYLOGDATA + idx);

                    baseDomManager.update(accessLog);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0014_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void createTestB0015_01(){

        AT_AccessLog accessLog = baseDomManager.getAccessLog(ALREADYLOGID);
        if ( null == accessLog ) {

            accessLog = new AT_AccessLog();

            accessLog.setLogId(ALREADYLOGID);
            accessLog.setTimeStamp(getSyoriTime(ALREADYLOGJIKOKU));
            accessLog.setSyoriUserId(ALREADYSYORIUSERID);
            accessLog.setIpAddress(ALREADYIPADDRESS);
            accessLog.setSessionId(ALREADYSESSIONID);
            accessLog.setLogKindCd(ALREADYLOGSYUBETUKBN);
            accessLog.setSubSystemId(ALREADYSUBSYSTEMID);
            accessLog.setCategoryId(ALREADYCATEGORYID);
            accessLog.setKinouId(ALREADYKINOUID);
            accessLog.setLogData(ALREADYLOGDATA);
            accessLog.setSyousaiKensuu(ALREADYSYOUSAILOGKENSUU);

            baseDomManager.insert(accessLog);
        }
    }

    @Transactional
    public void createTestB0015_02(){

        AT_AccessLog accessLog = baseDomManager.getAccessLog(ALREADYLOGID);
        if ( null != accessLog ) {

            AT_AccessLogSyousai accessLogSyousai = null;
            for ( int idx = 1; idx <= 350; idx++ ) {

                accessLogSyousai = accessLog.getAccessLogSyousai(idx);
                if ( null == accessLogSyousai ) {

                    accessLogSyousai = accessLog.createAccessLogSyousai();
                    accessLogSyousai.setSyousaiEdaNo((long) idx);
                    accessLogSyousai.setLogSyousaiData(ALREADYLOGDATA + idx);

                    baseDomManager.update(accessLog);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0015_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void createTestB0016_01(){

        AT_AccessLog accessLog = baseDomManager.getAccessLog(ALREADYLOGID);
        if ( null == accessLog ) {

            accessLog = new AT_AccessLog();

            accessLog.setLogId(ALREADYLOGID);
            accessLog.setTimeStamp(getSyoriTime(ALREADYLOGJIKOKU));
            accessLog.setSyoriUserId(ALREADYSYORIUSERID);
            accessLog.setIpAddress(ALREADYIPADDRESS);
            accessLog.setSessionId(ALREADYSESSIONID);
            accessLog.setLogKindCd(ALREADYLOGSYUBETUKBN);
            accessLog.setSubSystemId(ALREADYSUBSYSTEMID);
            accessLog.setCategoryId(ALREADYCATEGORYID);
            accessLog.setKinouId(ALREADYKINOUID);
            accessLog.setLogData(ALREADYLOGDATA);
            accessLog.setSyousaiKensuu(ALREADYSYOUSAILOGKENSUU);

            baseDomManager.insert(accessLog);
        }
    }

    @Transactional
    public void createTestB0016_02(){

        AT_AccessLog accessLog = baseDomManager.getAccessLog(ALREADYLOGID);
        if ( null != accessLog ) {

            AT_AccessLogSyousai accessLogSyousai = null;
            for ( int idx = 1; idx <= 350; idx++ ) {

                accessLogSyousai = accessLog.getAccessLogSyousai(idx);
                if ( null == accessLogSyousai ) {

                    accessLogSyousai = accessLog.createAccessLogSyousai();
                    accessLogSyousai.setSyousaiEdaNo((long) idx);
                    accessLogSyousai.setLogSyousaiData(ALREADYLOGDATA + idx);

                    baseDomManager.update(accessLog);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0016_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void createTestB0017_01(){

        AT_AccessLog accessLog = baseDomManager.getAccessLog(ALREADYLOGID);
        if ( null == accessLog ) {

            accessLog = new AT_AccessLog();

            accessLog.setLogId(ALREADYLOGID);
            accessLog.setTimeStamp(getSyoriTime(ALREADYLOGJIKOKU));
            accessLog.setSyoriUserId(ALREADYSYORIUSERID);
            accessLog.setIpAddress(ALREADYIPADDRESS);
            accessLog.setSessionId(ALREADYSESSIONID);
            accessLog.setLogKindCd(ALREADYLOGSYUBETUKBN);
            accessLog.setSubSystemId(ALREADYSUBSYSTEMID);
            accessLog.setCategoryId(ALREADYCATEGORYID);
            accessLog.setKinouId(ALREADYKINOUID);
            accessLog.setLogData(ALREADYLOGDATA);
            accessLog.setSyousaiKensuu(ALREADYSYOUSAILOGKENSUU);

            baseDomManager.insert(accessLog);
        }
    }

    @Transactional
    public void createTestB0017_02(){

        AT_AccessLog accessLog = baseDomManager.getAccessLog(ALREADYLOGID);
        if ( null != accessLog ) {

            AT_AccessLogSyousai accessLogSyousai = null;
            for ( int idx = 1; idx <= 350; idx++ ) {

                accessLogSyousai = accessLog.getAccessLogSyousai(idx);
                if ( null == accessLogSyousai ) {

                    accessLogSyousai = accessLog.createAccessLogSyousai();
                    accessLogSyousai.setSyousaiEdaNo((long) idx);
                    accessLogSyousai.setLogSyousaiData(ALREADYLOGDATA + idx);

                    baseDomManager.update(accessLog);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0017_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void createTestB0018_01(){

        AT_AccessLog accessLog = baseDomManager.getAccessLog(ALREADYLOGID);
        if ( null == accessLog ) {

            accessLog = new AT_AccessLog();

            accessLog.setLogId(ALREADYLOGID);
            accessLog.setTimeStamp(getSyoriTime(ALREADYLOGJIKOKU));
            accessLog.setSyoriUserId(ALREADYSYORIUSERID);
            accessLog.setIpAddress(ALREADYIPADDRESS);
            accessLog.setSessionId(ALREADYSESSIONID);
            accessLog.setLogKindCd(ALREADYLOGSYUBETUKBN);
            accessLog.setSubSystemId(ALREADYSUBSYSTEMID);
            accessLog.setCategoryId(ALREADYCATEGORYID);
            accessLog.setKinouId(ALREADYKINOUID);
            accessLog.setLogData(ALREADYLOGDATA);
            accessLog.setSyousaiKensuu(ALREADYSYOUSAILOGKENSUU);

            baseDomManager.insert(accessLog);
        }
    }

    @Transactional
    public void createTestB0018_02(){

        AT_AccessLog accessLog = baseDomManager.getAccessLog(ALREADYLOGID);
        if ( null != accessLog ) {

            AT_AccessLogSyousai accessLogSyousai = null;
            for ( int idx = 1; idx <= 350; idx++ ) {

                accessLogSyousai = accessLog.getAccessLogSyousai(idx);
                if ( null == accessLogSyousai ) {

                    accessLogSyousai = accessLog.createAccessLogSyousai();
                    accessLogSyousai.setSyousaiEdaNo((long) idx);
                    accessLogSyousai.setLogSyousaiData(ALREADYLOGDATA + idx);

                    baseDomManager.update(accessLog);
                }
            }
        }
    }

    @Transactional
    public void deleteTestB0018_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void deleteTestB0019_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    @Transactional
    public void deleteTestB0020_01(){

        List<AT_AccessLog> accessLogList = baseDomManager.getAllAccessLogs();
        if ( null != accessLogList ) {

            for( AT_AccessLog accesslog : accessLogList ) {
                accesslog.getAccessLogSyousais().removeAll(accesslog.getAccessLogSyousais());

                baseDomManager.update(accesslog);
            }

            baseDomManager.delete(accessLogList);
        }
    }

    private long getSyoriTime(BizDate pSyoriYmd){

        Date syoriTime = pSyoriYmd.toDate();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(syoriTime);

        return Long.valueOf(calendar.getTimeInMillis());
    }
}
