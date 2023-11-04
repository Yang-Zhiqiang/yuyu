package yuyu.def.biz.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBResults;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * アクセスログ作成（日次）<br />
 * アクセスログテーブルエンティティリスト取得　アクセスログ出力時刻範囲<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getAccessLogsBySyoriYmdFromSyoriYmdTo {

    @Inject
    BizDomManager bizDomManager;
    BaseDomManager baseDomManager;


    @BeforeClass
    @Transactional()
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        try (ExDBResults<AT_AccessLog> exDBResults = bizDomManager.getAccessLogsBySyoriYmdFromSyoriYmdTo(20161030000000000L,20161101000000000L)){

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }

        AT_AccessLog accessLog11 = new AT_AccessLog("11");
        accessLog11.setTimeStamp(20161030235959999L);
        accessLog11.setLogKindCd(C_AccessLogSyubetuKbn.BLNK);
        accessLog11.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog11 );

        AT_AccessLog accessLog12= new AT_AccessLog("12");
        accessLog12.setTimeStamp(20161030235959999L);
        accessLog12.setLogKindCd(C_AccessLogSyubetuKbn.LOGIN);
        accessLog12.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog12);

        AT_AccessLog accessLog13= new AT_AccessLog("13");
        accessLog13.setTimeStamp(20161030235959999L);
        accessLog13.setLogKindCd(C_AccessLogSyubetuKbn.LOGIN_FAILURE);
        accessLog13.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog13);

        AT_AccessLog accessLog14= new AT_AccessLog("14");
        accessLog14.setTimeStamp(20161030235959999L);
        accessLog14.setLogKindCd(C_AccessLogSyubetuKbn.LOCKOUT);
        accessLog14.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog14);

        AT_AccessLog accessLog15= new AT_AccessLog("15");
        accessLog15.setTimeStamp(20161030235959999L);
        accessLog15.setLogKindCd(C_AccessLogSyubetuKbn.UNLOCK);
        accessLog15.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog15);

        AT_AccessLog accessLog16= new AT_AccessLog("16");
        accessLog16.setTimeStamp(20161030235959999L);
        accessLog16.setLogKindCd(C_AccessLogSyubetuKbn.LOGOUT);
        accessLog16.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog16);

        AT_AccessLog accessLog17= new AT_AccessLog("17");
        accessLog17.setTimeStamp(20161030235959999L);
        accessLog17.setLogKindCd(C_AccessLogSyubetuKbn.LOGOUT_AUTO);
        accessLog17.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog17);

        AT_AccessLog accessLog18= new AT_AccessLog("18");
        accessLog18.setTimeStamp(20161030235959999L);
        accessLog18.setLogKindCd(C_AccessLogSyubetuKbn.TIMEOUT);
        accessLog18.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog18);

        AT_AccessLog accessLog19= new AT_AccessLog("19");
        accessLog19.setTimeStamp(20161030235959999L);
        accessLog19.setLogKindCd(C_AccessLogSyubetuKbn.AUTH_VIOLATION);
        accessLog19.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog19);

        AT_AccessLog accessLog20= new AT_AccessLog("20");
        accessLog20.setTimeStamp(20161030235959999L);
        accessLog20.setLogKindCd(C_AccessLogSyubetuKbn.USER_ADD);
        accessLog20.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog20);

        AT_AccessLog accessLog21= new AT_AccessLog("21");
        accessLog21.setTimeStamp(20161030235959999L);
        accessLog21.setLogKindCd(C_AccessLogSyubetuKbn.USER_MODIFY);
        accessLog21.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog21);

        AT_AccessLog accessLog22= new AT_AccessLog("22");
        accessLog22.setTimeStamp(20161030235959999L);
        accessLog22.setLogKindCd(C_AccessLogSyubetuKbn.USER_DELETE);
        accessLog22.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog22);

        AT_AccessLog accessLog23= new AT_AccessLog("23");
        accessLog23.setTimeStamp(20161030235959999L);
        accessLog23.setLogKindCd(C_AccessLogSyubetuKbn.PASSWORD_ALTER);
        accessLog23.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog23);

        AT_AccessLog accessLog24= new AT_AccessLog("24");
        accessLog24.setTimeStamp(20161030235959999L);
        accessLog24.setLogKindCd(C_AccessLogSyubetuKbn.DB_SELECT);
        accessLog24.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog24);

        AT_AccessLog accessLog25= new AT_AccessLog("25");
        accessLog25.setTimeStamp(20161030235959999L);
        accessLog25.setLogKindCd(C_AccessLogSyubetuKbn.DB_INSERT);
        accessLog25.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog25);

        AT_AccessLog accessLog26= new AT_AccessLog("26");
        accessLog26.setTimeStamp(20161030235959999L);
        accessLog26.setLogKindCd(C_AccessLogSyubetuKbn.DB_UPDATE);
        accessLog26.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog26);

        AT_AccessLog accessLog27= new AT_AccessLog("27");
        accessLog27.setTimeStamp(20161030235959999L);
        accessLog27.setLogKindCd(C_AccessLogSyubetuKbn.DB_DELETE);
        accessLog27.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog27);

        AT_AccessLog accessLog28= new AT_AccessLog("28");
        accessLog28.setTimeStamp(20161030235959999L);
        accessLog28.setLogKindCd(C_AccessLogSyubetuKbn.DB_COMMIT);
        accessLog28.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog28);

        AT_AccessLog accessLog29= new AT_AccessLog("29");
        accessLog29.setTimeStamp(20161030235959999L);
        accessLog29.setLogKindCd(C_AccessLogSyubetuKbn.DB_ROLLBACK);
        accessLog29.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog29);

        AT_AccessLog accessLog30= new AT_AccessLog("30");
        accessLog30.setTimeStamp(20161030235959999L);
        accessLog30.setLogKindCd(C_AccessLogSyubetuKbn.DB_DDL);
        accessLog30.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog30);

        AT_AccessLog accessLog31= new AT_AccessLog("31");
        accessLog31.setTimeStamp(20161030235959999L);
        accessLog31.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_BEGIN);
        accessLog31.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog31);

        AT_AccessLog accessLog32= new AT_AccessLog("32");
        accessLog32.setTimeStamp(20161030235959999L);
        accessLog32.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_END);
        accessLog32.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog32);

        AT_AccessLog accessLog33= new AT_AccessLog("33");
        accessLog33.setTimeStamp(20161030235959999L);
        accessLog33.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_FAILURE);
        accessLog33.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog33);

        AT_AccessLog accessLog34= new AT_AccessLog("34");
        accessLog34.setTimeStamp(20161030235959999L);
        accessLog34.setLogKindCd(C_AccessLogSyubetuKbn.REPORT);
        accessLog34.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog34);

        AT_AccessLog accessLog35= new AT_AccessLog("35");
        accessLog35.setTimeStamp(20161030235959999L);
        accessLog35.setLogKindCd(C_AccessLogSyubetuKbn.KADOU_TIME_PAST);
        accessLog35.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog35);

        AT_AccessLog accessLog36= new AT_AccessLog("36");
        accessLog36.setTimeStamp(20161030235959999L);
        accessLog36.setLogKindCd(C_AccessLogSyubetuKbn.BATCH_BEGIN);
        accessLog36.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog36);

        AT_AccessLog accessLog37= new AT_AccessLog("37");
        accessLog37.setTimeStamp(20161030235959999L);
        accessLog37.setLogKindCd(C_AccessLogSyubetuKbn.BATCH_END);
        accessLog37.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog37);

        AT_AccessLog accessLog38= new AT_AccessLog("38");
        accessLog38.setTimeStamp(20161030235959999L);
        accessLog38.setLogKindCd(C_AccessLogSyubetuKbn.FILE_READ);
        accessLog38.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog38);

        AT_AccessLog accessLog39= new AT_AccessLog("39");
        accessLog39.setTimeStamp(20161030235959999L);
        accessLog39.setLogKindCd(C_AccessLogSyubetuKbn.FILE_WRITE);
        accessLog39.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog39);

        AT_AccessLog accessLog40= new AT_AccessLog("40");
        accessLog40.setTimeStamp(20161030235959999L);
        accessLog40.setLogKindCd(C_AccessLogSyubetuKbn.FILE_MOVE);
        accessLog40.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog40);

        AT_AccessLog accessLog41= new AT_AccessLog("41");
        accessLog41.setTimeStamp(20161030235959999L);
        accessLog41.setLogKindCd(C_AccessLogSyubetuKbn.FILE_COPY);
        accessLog41.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog41);

        AT_AccessLog accessLog42= new AT_AccessLog("42");
        accessLog42.setTimeStamp(20161030235959999L);
        accessLog42.setLogKindCd(C_AccessLogSyubetuKbn.FILE_REMOVE);
        accessLog42.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog42);

        AT_AccessLog accessLog43= new AT_AccessLog("43");
        accessLog43.setTimeStamp(20161030235959999L);
        accessLog43.setLogKindCd(C_AccessLogSyubetuKbn.BLNK);
        accessLog43.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog43);

        AT_AccessLog accessLog44= new AT_AccessLog("44");
        accessLog44.setTimeStamp(20161101000000000L);
        accessLog44.setLogKindCd(C_AccessLogSyubetuKbn.LOGIN);
        accessLog44.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog44);

        AT_AccessLog accessLog45= new AT_AccessLog("45");
        accessLog45.setTimeStamp(20161101000000000L);
        accessLog45.setLogKindCd(C_AccessLogSyubetuKbn.LOGIN_FAILURE);
        accessLog45.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog45);

        AT_AccessLog accessLog46= new AT_AccessLog("46");
        accessLog46.setTimeStamp(20161101000000000L);
        accessLog46.setLogKindCd(C_AccessLogSyubetuKbn.LOCKOUT);
        accessLog46.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog46);

        AT_AccessLog accessLog47= new AT_AccessLog("47");
        accessLog47.setTimeStamp(20161101000000000L);
        accessLog47.setLogKindCd(C_AccessLogSyubetuKbn.UNLOCK);
        accessLog47.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog47);

        AT_AccessLog accessLog48= new AT_AccessLog("48");
        accessLog48.setTimeStamp(20161101000000000L);
        accessLog48.setLogKindCd(C_AccessLogSyubetuKbn.LOGOUT);
        accessLog48.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog48);

        AT_AccessLog accessLog49= new AT_AccessLog("49");
        accessLog49.setTimeStamp(20161101000000000L);
        accessLog49.setLogKindCd(C_AccessLogSyubetuKbn.LOGOUT_AUTO);
        accessLog49.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog49);

        AT_AccessLog accessLog50= new AT_AccessLog("50");
        accessLog50.setTimeStamp(20161101000000000L);
        accessLog50.setLogKindCd(C_AccessLogSyubetuKbn.TIMEOUT);
        accessLog50.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog50);

        AT_AccessLog accessLog51= new AT_AccessLog("51");
        accessLog51.setTimeStamp(20161101000000000L);
        accessLog51.setLogKindCd(C_AccessLogSyubetuKbn.AUTH_VIOLATION);
        accessLog51.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog51);

        AT_AccessLog accessLog52= new AT_AccessLog("52");
        accessLog52.setTimeStamp(20161101000000000L);
        accessLog52.setLogKindCd(C_AccessLogSyubetuKbn.USER_ADD);
        accessLog52.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog52);

        AT_AccessLog accessLog53= new AT_AccessLog("53");
        accessLog53.setTimeStamp(20161101000000000L);
        accessLog53.setLogKindCd(C_AccessLogSyubetuKbn.USER_MODIFY);
        accessLog53.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog53);

        AT_AccessLog accessLog54= new AT_AccessLog("54");
        accessLog54.setTimeStamp(20161101000000000L);
        accessLog54.setLogKindCd(C_AccessLogSyubetuKbn.USER_DELETE);
        accessLog54.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog54);

        AT_AccessLog accessLog55= new AT_AccessLog("55");
        accessLog55.setTimeStamp(20161101000000000L);
        accessLog55.setLogKindCd(C_AccessLogSyubetuKbn.PASSWORD_ALTER);
        accessLog55.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog55);

        AT_AccessLog accessLog56= new AT_AccessLog("56");
        accessLog56.setTimeStamp(20161101000000000L);
        accessLog56.setLogKindCd(C_AccessLogSyubetuKbn.DB_SELECT);
        accessLog56.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog56);

        AT_AccessLog accessLog57= new AT_AccessLog("57");
        accessLog57.setTimeStamp(20161101000000000L);
        accessLog57.setLogKindCd(C_AccessLogSyubetuKbn.DB_INSERT);
        accessLog57.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog57);

        AT_AccessLog accessLog58= new AT_AccessLog("58");
        accessLog58.setTimeStamp(20161101000000000L);
        accessLog58.setLogKindCd(C_AccessLogSyubetuKbn.DB_UPDATE);
        accessLog58.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog58);

        AT_AccessLog accessLog59= new AT_AccessLog("59");
        accessLog59.setTimeStamp(20161101000000000L);
        accessLog59.setLogKindCd(C_AccessLogSyubetuKbn.DB_DELETE);
        accessLog59.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog59);

        AT_AccessLog accessLog60= new AT_AccessLog("60");
        accessLog60.setTimeStamp(20161101000000000L);
        accessLog60.setLogKindCd(C_AccessLogSyubetuKbn.DB_COMMIT);
        accessLog60.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog60);

        AT_AccessLog accessLog61= new AT_AccessLog("61");
        accessLog61.setTimeStamp(20161101000000000L);
        accessLog61.setLogKindCd(C_AccessLogSyubetuKbn.DB_ROLLBACK);
        accessLog61.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog61);

        AT_AccessLog accessLog62= new AT_AccessLog("62");
        accessLog62.setTimeStamp(20161101000000000L);
        accessLog62.setLogKindCd(C_AccessLogSyubetuKbn.DB_DDL);
        accessLog62.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog62);

        AT_AccessLog accessLog63= new AT_AccessLog("63");
        accessLog63.setTimeStamp(20161101000000000L);
        accessLog63.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_BEGIN);
        accessLog63.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog63);

        AT_AccessLog accessLog64= new AT_AccessLog("64");
        accessLog64.setTimeStamp(20161101000000000L);
        accessLog64.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_END);
        accessLog64.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog64);

        AT_AccessLog accessLog65= new AT_AccessLog("65");
        accessLog65.setTimeStamp(20161101000000000L);
        accessLog65.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_FAILURE);
        accessLog65.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog65);

        AT_AccessLog accessLog66= new AT_AccessLog("66");
        accessLog66.setTimeStamp(20161101000000000L);
        accessLog66.setLogKindCd(C_AccessLogSyubetuKbn.REPORT);
        accessLog66.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog66);

        AT_AccessLog accessLog67= new AT_AccessLog("67");
        accessLog67.setTimeStamp(20161101000000000L);
        accessLog67.setLogKindCd(C_AccessLogSyubetuKbn.KADOU_TIME_PAST);
        accessLog67.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog67);

        AT_AccessLog accessLog68= new AT_AccessLog("68");
        accessLog68.setTimeStamp(20161101000000000L);
        accessLog68.setLogKindCd(C_AccessLogSyubetuKbn.BATCH_BEGIN);
        accessLog68.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog68);

        AT_AccessLog accessLog69= new AT_AccessLog("69");
        accessLog69.setTimeStamp(20161101000000000L);
        accessLog69.setLogKindCd(C_AccessLogSyubetuKbn.BATCH_END);
        accessLog69.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog69);

        AT_AccessLog accessLog70= new AT_AccessLog("70");
        accessLog70.setTimeStamp(20161101000000000L);
        accessLog70.setLogKindCd(C_AccessLogSyubetuKbn.FILE_READ);
        accessLog70.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog70);

        AT_AccessLog accessLog71= new AT_AccessLog("71");
        accessLog71.setTimeStamp(20161101000000000L);
        accessLog71.setLogKindCd(C_AccessLogSyubetuKbn.FILE_WRITE);
        accessLog71.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog71);

        AT_AccessLog accessLog72= new AT_AccessLog("72");
        accessLog72.setTimeStamp(20161101000000000L);
        accessLog72.setLogKindCd(C_AccessLogSyubetuKbn.FILE_MOVE);
        accessLog72.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog72);

        AT_AccessLog accessLog73= new AT_AccessLog("73");
        accessLog73.setTimeStamp(20161101000000000L);
        accessLog73.setLogKindCd(C_AccessLogSyubetuKbn.FILE_COPY);
        accessLog73.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog73);

        AT_AccessLog accessLog74= new AT_AccessLog("74");
        accessLog74.setTimeStamp(20161101000000000L);
        accessLog74.setLogKindCd(C_AccessLogSyubetuKbn.FILE_REMOVE);
        accessLog74.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog74);

        AT_AccessLog accessLog75= new AT_AccessLog("75");
        accessLog75.setTimeStamp(20161101000000002L);
        accessLog75.setLogKindCd(C_AccessLogSyubetuKbn.BLNK);
        accessLog75.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog75);

        AT_AccessLog accessLog76= new AT_AccessLog("76");
        accessLog76.setTimeStamp(20161101000000002L);
        accessLog76.setLogKindCd(C_AccessLogSyubetuKbn.LOGIN);
        accessLog76.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog76);

        AT_AccessLog accessLog77= new AT_AccessLog("77");
        accessLog77.setTimeStamp(20161101000000002L);
        accessLog77.setLogKindCd(C_AccessLogSyubetuKbn.LOGIN_FAILURE);
        accessLog77.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog77);

        AT_AccessLog accessLog78= new AT_AccessLog("78");
        accessLog78.setTimeStamp(20161101000000002L);
        accessLog78.setLogKindCd(C_AccessLogSyubetuKbn.LOCKOUT);
        accessLog78.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog78);

        AT_AccessLog accessLog79= new AT_AccessLog("79");
        accessLog79.setTimeStamp(20161101000000002L);
        accessLog79.setLogKindCd(C_AccessLogSyubetuKbn.UNLOCK);
        accessLog79.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog79);

        AT_AccessLog accessLog80= new AT_AccessLog("80");
        accessLog80.setTimeStamp(20161101000000002L);
        accessLog80.setLogKindCd(C_AccessLogSyubetuKbn.LOGOUT);
        accessLog80.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog80);

        AT_AccessLog accessLog81= new AT_AccessLog("81");
        accessLog81.setTimeStamp(20161101000000002L);
        accessLog81.setLogKindCd(C_AccessLogSyubetuKbn.LOGOUT_AUTO);
        accessLog81.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog81);

        AT_AccessLog accessLog82= new AT_AccessLog("82");
        accessLog82.setTimeStamp(20161101000000002L);
        accessLog82.setLogKindCd(C_AccessLogSyubetuKbn.TIMEOUT);
        accessLog82.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog82);

        AT_AccessLog accessLog83= new AT_AccessLog("83");
        accessLog83.setTimeStamp(20161101000000002L);
        accessLog83.setLogKindCd(C_AccessLogSyubetuKbn.AUTH_VIOLATION);
        accessLog83.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog83);

        AT_AccessLog accessLog84= new AT_AccessLog("84");
        accessLog84.setTimeStamp(20161101000000002L);
        accessLog84.setLogKindCd(C_AccessLogSyubetuKbn.USER_ADD);
        accessLog84.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog84);

        AT_AccessLog accessLog85= new AT_AccessLog("85");
        accessLog85.setTimeStamp(20161101000000002L);
        accessLog85.setLogKindCd(C_AccessLogSyubetuKbn.USER_MODIFY);
        accessLog85.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog85);

        AT_AccessLog accessLog86= new AT_AccessLog("86");
        accessLog86.setTimeStamp(20161101000000002L);
        accessLog86.setLogKindCd(C_AccessLogSyubetuKbn.USER_DELETE);
        accessLog86.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog86);

        AT_AccessLog accessLog87= new AT_AccessLog("87");
        accessLog87.setTimeStamp(20161101000000002L);
        accessLog87.setLogKindCd(C_AccessLogSyubetuKbn.PASSWORD_ALTER);
        accessLog87.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog87);

        AT_AccessLog accessLog88= new AT_AccessLog("88");
        accessLog88.setTimeStamp(20161101000000002L);
        accessLog88.setLogKindCd(C_AccessLogSyubetuKbn.DB_SELECT);
        accessLog88.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog88);

        AT_AccessLog accessLog89= new AT_AccessLog("89");
        accessLog89.setTimeStamp(20161101000000002L);
        accessLog89.setLogKindCd(C_AccessLogSyubetuKbn.DB_INSERT);
        accessLog89.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog89);

        AT_AccessLog accessLog90= new AT_AccessLog("90");
        accessLog90.setTimeStamp(20161101000000002L);
        accessLog90.setLogKindCd(C_AccessLogSyubetuKbn.DB_UPDATE);
        accessLog90.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog90);

        AT_AccessLog accessLog91= new AT_AccessLog("91");
        accessLog91.setTimeStamp(20161101000000002L);
        accessLog91.setLogKindCd(C_AccessLogSyubetuKbn.DB_DELETE);
        accessLog91.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog91);

        AT_AccessLog accessLog92= new AT_AccessLog("92");
        accessLog92.setTimeStamp(20161101000000002L);
        accessLog92.setLogKindCd(C_AccessLogSyubetuKbn.DB_COMMIT);
        accessLog92.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog92);

        AT_AccessLog accessLog93= new AT_AccessLog("93");
        accessLog93.setTimeStamp(20161101000000002L);
        accessLog93.setLogKindCd(C_AccessLogSyubetuKbn.DB_ROLLBACK);
        accessLog93.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog93);

        AT_AccessLog accessLog94= new AT_AccessLog("94");
        accessLog94.setTimeStamp(20161101000000002L);
        accessLog94.setLogKindCd(C_AccessLogSyubetuKbn.DB_DDL);
        accessLog94.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog94);

        AT_AccessLog accessLog95= new AT_AccessLog("95");
        accessLog95.setTimeStamp(20161101000000002L);
        accessLog95.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_BEGIN);
        accessLog95.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog95);

        AT_AccessLog accessLog96= new AT_AccessLog("96");
        accessLog96.setTimeStamp(20161101000000002L);
        accessLog96.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_END);
        accessLog96.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog96);

        AT_AccessLog accessLog97= new AT_AccessLog("97");
        accessLog97.setTimeStamp(20161101000000002L);
        accessLog97.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_FAILURE);
        accessLog97.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog97);

        AT_AccessLog accessLog98= new AT_AccessLog("98");
        accessLog98.setTimeStamp(20161101000000002L);
        accessLog98.setLogKindCd(C_AccessLogSyubetuKbn.REPORT);
        accessLog98.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog98);

        AT_AccessLog accessLog99= new AT_AccessLog("99");
        accessLog99.setTimeStamp(20161101000000002L);
        accessLog99.setLogKindCd(C_AccessLogSyubetuKbn.KADOU_TIME_PAST);
        accessLog99.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog99);

        AT_AccessLog accessLog100= new AT_AccessLog("100");
        accessLog100.setTimeStamp(20161101000000002L);
        accessLog100.setLogKindCd(C_AccessLogSyubetuKbn.BATCH_BEGIN);
        accessLog100.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog100);

        AT_AccessLog accessLog101= new AT_AccessLog("101");
        accessLog101.setTimeStamp(20161101000000002L);
        accessLog101.setLogKindCd(C_AccessLogSyubetuKbn.BATCH_END);
        accessLog101.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog101);

        AT_AccessLog accessLog102= new AT_AccessLog("102");
        accessLog102.setTimeStamp(20161101000000002L);
        accessLog102.setLogKindCd(C_AccessLogSyubetuKbn.FILE_READ);
        accessLog102.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog102);

        AT_AccessLog accessLog103= new AT_AccessLog("103");
        accessLog103.setTimeStamp(20161101000000002L);
        accessLog103.setLogKindCd(C_AccessLogSyubetuKbn.FILE_WRITE);
        accessLog103.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog103);

        AT_AccessLog accessLog104= new AT_AccessLog("104");
        accessLog104.setTimeStamp(20161101000000002L);
        accessLog104.setLogKindCd(C_AccessLogSyubetuKbn.FILE_MOVE);
        accessLog104.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog104);

        AT_AccessLog accessLog105= new AT_AccessLog("105");
        accessLog105.setTimeStamp(20161101000000002L);
        accessLog105.setLogKindCd(C_AccessLogSyubetuKbn.FILE_COPY);
        accessLog105.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog105);

        AT_AccessLog accessLog106= new AT_AccessLog("106");
        accessLog106.setTimeStamp(20161101000000002L);
        accessLog106.setLogKindCd(C_AccessLogSyubetuKbn.FILE_REMOVE);
        accessLog106.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog106);

        AT_AccessLog accessLog107= new AT_AccessLog("107");
        accessLog107.setTimeStamp(20161101000000001L);
        accessLog107.setLogKindCd(C_AccessLogSyubetuKbn.BLNK);
        accessLog107.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog107);

        AT_AccessLog accessLog108= new AT_AccessLog("108");
        accessLog108.setTimeStamp(20161101000000001L);
        accessLog108.setLogKindCd(C_AccessLogSyubetuKbn.LOGIN);
        accessLog108.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog108);

        AT_AccessLog accessLog109= new AT_AccessLog("109");
        accessLog109.setTimeStamp(20161101000000001L);
        accessLog109.setLogKindCd(C_AccessLogSyubetuKbn.LOGIN_FAILURE);
        accessLog109.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog109);

        AT_AccessLog accessLog110= new AT_AccessLog("110");
        accessLog110.setTimeStamp(20161101000000001L);
        accessLog110.setLogKindCd(C_AccessLogSyubetuKbn.LOCKOUT);
        accessLog110.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog110);

        AT_AccessLog accessLog111= new AT_AccessLog("111");
        accessLog111.setTimeStamp(20161101000000001L);
        accessLog111.setLogKindCd(C_AccessLogSyubetuKbn.UNLOCK);
        accessLog111.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog111);

        AT_AccessLog accessLog112= new AT_AccessLog("112");
        accessLog112.setTimeStamp(20161101000000001L);
        accessLog112.setLogKindCd(C_AccessLogSyubetuKbn.LOGOUT);
        accessLog112.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog112);

        AT_AccessLog accessLog113= new AT_AccessLog("113");
        accessLog113.setTimeStamp(20161101000000001L);
        accessLog113.setLogKindCd(C_AccessLogSyubetuKbn.LOGOUT_AUTO);
        accessLog113.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog113);

        AT_AccessLog accessLog114= new AT_AccessLog("114");
        accessLog114.setTimeStamp(20161101000000001L);
        accessLog114.setLogKindCd(C_AccessLogSyubetuKbn.TIMEOUT);
        accessLog114.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog114);

        AT_AccessLog accessLog115= new AT_AccessLog("115");
        accessLog115.setTimeStamp(20161101000000001L);
        accessLog115.setLogKindCd(C_AccessLogSyubetuKbn.AUTH_VIOLATION);
        accessLog115.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog115);

        AT_AccessLog accessLog116= new AT_AccessLog("116");
        accessLog116.setTimeStamp(20161101000000001L);
        accessLog116.setLogKindCd(C_AccessLogSyubetuKbn.USER_ADD);
        accessLog116.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog116);

        AT_AccessLog accessLog117= new AT_AccessLog("117");
        accessLog117.setTimeStamp(20161101000000001L);
        accessLog117.setLogKindCd(C_AccessLogSyubetuKbn.USER_MODIFY);
        accessLog117.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog117);

        AT_AccessLog accessLog118= new AT_AccessLog("118");
        accessLog118.setTimeStamp(20161101000000001L);
        accessLog118.setLogKindCd(C_AccessLogSyubetuKbn.USER_DELETE);
        accessLog118.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog118);

        AT_AccessLog accessLog119= new AT_AccessLog("119");
        accessLog119.setTimeStamp(20161101000000001L);
        accessLog119.setLogKindCd(C_AccessLogSyubetuKbn.PASSWORD_ALTER);
        accessLog119.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog119);

        AT_AccessLog accessLog120= new AT_AccessLog("120");
        accessLog120.setTimeStamp(20161101000000001L);
        accessLog120.setLogKindCd(C_AccessLogSyubetuKbn.DB_SELECT);
        accessLog120.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog120);

        AT_AccessLog accessLog121= new AT_AccessLog("121");
        accessLog121.setTimeStamp(20161101000000001L);
        accessLog121.setLogKindCd(C_AccessLogSyubetuKbn.DB_INSERT);
        accessLog121.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog121);

        AT_AccessLog accessLog122= new AT_AccessLog("122");
        accessLog122.setTimeStamp(20161101000000001L);
        accessLog122.setLogKindCd(C_AccessLogSyubetuKbn.DB_UPDATE);
        accessLog122.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog122);

        AT_AccessLog accessLog123= new AT_AccessLog("123");
        accessLog123.setTimeStamp(20161101000000001L);
        accessLog123.setLogKindCd(C_AccessLogSyubetuKbn.DB_DELETE);
        accessLog123.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog123);

        AT_AccessLog accessLog124= new AT_AccessLog("124");
        accessLog124.setTimeStamp(20161101000000001L);
        accessLog124.setLogKindCd(C_AccessLogSyubetuKbn.DB_COMMIT);
        accessLog124.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog124);

        AT_AccessLog accessLog125= new AT_AccessLog("125");
        accessLog125.setTimeStamp(20161101000000001L);
        accessLog125.setLogKindCd(C_AccessLogSyubetuKbn.DB_ROLLBACK);
        accessLog125.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog125);

        AT_AccessLog accessLog126= new AT_AccessLog("126");
        accessLog126.setTimeStamp(20161101000000001L);
        accessLog126.setLogKindCd(C_AccessLogSyubetuKbn.DB_DDL);
        accessLog126.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog126);

        AT_AccessLog accessLog127= new AT_AccessLog("127");
        accessLog127.setTimeStamp(20161101000000001L);
        accessLog127.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_BEGIN);
        accessLog127.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog127);

        AT_AccessLog accessLog128= new AT_AccessLog("128");
        accessLog128.setTimeStamp(20161101000000001L);
        accessLog128.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_END);
        accessLog128.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog128);

        AT_AccessLog accessLog129= new AT_AccessLog("129");
        accessLog129.setTimeStamp(20161101000000001L);
        accessLog129.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_FAILURE);
        accessLog129.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog129);

        AT_AccessLog accessLog130= new AT_AccessLog("130");
        accessLog130.setTimeStamp(20161101000000001L);
        accessLog130.setLogKindCd(C_AccessLogSyubetuKbn.REPORT);
        accessLog130.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog130);

        AT_AccessLog accessLog131= new AT_AccessLog("131");
        accessLog131.setTimeStamp(20161101000000001L);
        accessLog131.setLogKindCd(C_AccessLogSyubetuKbn.KADOU_TIME_PAST);
        accessLog131.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog131);

        AT_AccessLog accessLog132= new AT_AccessLog("132");
        accessLog132.setTimeStamp(20161101000000001L);
        accessLog132.setLogKindCd(C_AccessLogSyubetuKbn.BATCH_BEGIN);
        accessLog132.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog132);

        AT_AccessLog accessLog133= new AT_AccessLog("133");
        accessLog133.setTimeStamp(20161101000000001L);
        accessLog133.setLogKindCd(C_AccessLogSyubetuKbn.BATCH_END);
        accessLog133.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog133);

        AT_AccessLog accessLog134= new AT_AccessLog("134");
        accessLog134.setTimeStamp(20161101000000001L);
        accessLog134.setLogKindCd(C_AccessLogSyubetuKbn.FILE_READ);
        accessLog134.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog134);

        AT_AccessLog accessLog135= new AT_AccessLog("135");
        accessLog135.setTimeStamp(20161101000000001L);
        accessLog135.setLogKindCd(C_AccessLogSyubetuKbn.FILE_WRITE);
        accessLog135.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog135);

        AT_AccessLog accessLog136= new AT_AccessLog("136");
        accessLog136.setTimeStamp(20161101000000001L);
        accessLog136.setLogKindCd(C_AccessLogSyubetuKbn.FILE_MOVE);
        accessLog136.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog136);

        AT_AccessLog accessLog137= new AT_AccessLog("137");
        accessLog137.setTimeStamp(20161101000000001L);
        accessLog137.setLogKindCd(C_AccessLogSyubetuKbn.FILE_COPY);
        accessLog137.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog137);

        AT_AccessLog accessLog138= new AT_AccessLog("138");
        accessLog138.setTimeStamp(20161101000000001L);
        accessLog138.setLogKindCd(C_AccessLogSyubetuKbn.FILE_REMOVE);
        accessLog138.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog138);

        AT_AccessLog accessLog139= new AT_AccessLog("139");
        accessLog139.setTimeStamp(20161101000000003L);
        accessLog139.setLogKindCd(C_AccessLogSyubetuKbn.BLNK);
        accessLog139.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog139);

        AT_AccessLog accessLog140= new AT_AccessLog("140");
        accessLog140.setTimeStamp(20161101000000003L);
        accessLog140.setLogKindCd(C_AccessLogSyubetuKbn.LOGIN);
        accessLog140.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog140);

        AT_AccessLog accessLog141= new AT_AccessLog("141");
        accessLog141.setTimeStamp(20161101000000003L);
        accessLog141.setLogKindCd(C_AccessLogSyubetuKbn.LOGIN_FAILURE);
        accessLog141.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog141);

        AT_AccessLog accessLog142= new AT_AccessLog("142");
        accessLog142.setTimeStamp(20161101000000003L);
        accessLog142.setLogKindCd(C_AccessLogSyubetuKbn.LOCKOUT);
        accessLog142.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog142);

        AT_AccessLog accessLog143= new AT_AccessLog("143");
        accessLog143.setTimeStamp(20161101000000003L);
        accessLog143.setLogKindCd(C_AccessLogSyubetuKbn.UNLOCK);
        accessLog143.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog143);

        AT_AccessLog accessLog144= new AT_AccessLog("144");
        accessLog144.setTimeStamp(20161101000000003L);
        accessLog144.setLogKindCd(C_AccessLogSyubetuKbn.LOGOUT);
        accessLog144.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog144);

        AT_AccessLog accessLog145= new AT_AccessLog("145");
        accessLog145.setTimeStamp(20161101000000003L);
        accessLog145.setLogKindCd(C_AccessLogSyubetuKbn.LOGOUT_AUTO);
        accessLog145.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog145);

        AT_AccessLog accessLog146= new AT_AccessLog("146");
        accessLog146.setTimeStamp(20161101000000003L);
        accessLog146.setLogKindCd(C_AccessLogSyubetuKbn.TIMEOUT);
        accessLog146.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog146);

        AT_AccessLog accessLog147= new AT_AccessLog("147");
        accessLog147.setTimeStamp(20161101000000003L);
        accessLog147.setLogKindCd(C_AccessLogSyubetuKbn.AUTH_VIOLATION);
        accessLog147.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog147);

        AT_AccessLog accessLog148= new AT_AccessLog("148");
        accessLog148.setTimeStamp(20161101000000003L);
        accessLog148.setLogKindCd(C_AccessLogSyubetuKbn.USER_ADD);
        accessLog148.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog148);

        AT_AccessLog accessLog149= new AT_AccessLog("149");
        accessLog149.setTimeStamp(20161101000000003L);
        accessLog149.setLogKindCd(C_AccessLogSyubetuKbn.USER_MODIFY);
        accessLog149.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog149);

        AT_AccessLog accessLog150= new AT_AccessLog("150");
        accessLog150.setTimeStamp(20161101000000003L);
        accessLog150.setLogKindCd(C_AccessLogSyubetuKbn.USER_DELETE);
        accessLog150.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog150);

        AT_AccessLog accessLog151= new AT_AccessLog("151");
        accessLog151.setTimeStamp(20161101000000003L);
        accessLog151.setLogKindCd(C_AccessLogSyubetuKbn.PASSWORD_ALTER);
        accessLog151.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog151);

        AT_AccessLog accessLog152= new AT_AccessLog("152");
        accessLog152.setTimeStamp(20161101000000003L);
        accessLog152.setLogKindCd(C_AccessLogSyubetuKbn.DB_SELECT);
        accessLog152.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog152);

        AT_AccessLog accessLog153= new AT_AccessLog("153");
        accessLog153.setTimeStamp(20161101000000003L);
        accessLog153.setLogKindCd(C_AccessLogSyubetuKbn.DB_INSERT);
        accessLog153.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog153);

        AT_AccessLog accessLog154= new AT_AccessLog("154");
        accessLog154.setTimeStamp(20161101000000003L);
        accessLog154.setLogKindCd(C_AccessLogSyubetuKbn.DB_UPDATE);
        accessLog154.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog154);

        AT_AccessLog accessLog155= new AT_AccessLog("155");
        accessLog155.setTimeStamp(20161101000000003L);
        accessLog155.setLogKindCd(C_AccessLogSyubetuKbn.DB_DELETE);
        accessLog155.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog155);

        AT_AccessLog accessLog156= new AT_AccessLog("156");
        accessLog156.setTimeStamp(20161101000000003L);
        accessLog156.setLogKindCd(C_AccessLogSyubetuKbn.DB_COMMIT);
        accessLog156.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog156);

        AT_AccessLog accessLog157= new AT_AccessLog("157");
        accessLog157.setTimeStamp(20161101000000003L);
        accessLog157.setLogKindCd(C_AccessLogSyubetuKbn.DB_ROLLBACK);
        accessLog157.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog157);

        AT_AccessLog accessLog158= new AT_AccessLog("158");
        accessLog158.setTimeStamp(20161101000000003L);
        accessLog158.setLogKindCd(C_AccessLogSyubetuKbn.DB_DDL);
        accessLog158.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog158);

        AT_AccessLog accessLog159= new AT_AccessLog("159");
        accessLog159.setTimeStamp(20161101000000003L);
        accessLog159.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_BEGIN);
        accessLog159.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog159);

        AT_AccessLog accessLog160= new AT_AccessLog("160");
        accessLog160.setTimeStamp(20161101000000003L);
        accessLog160.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_END);
        accessLog160.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog160);

        AT_AccessLog accessLog161= new AT_AccessLog("161");
        accessLog161.setTimeStamp(20161101000000003L);
        accessLog161.setLogKindCd(C_AccessLogSyubetuKbn.ACTION_FAILURE);
        accessLog161.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog161);

        AT_AccessLog accessLog162= new AT_AccessLog("162");
        accessLog162.setTimeStamp(20161101000000003L);
        accessLog162.setLogKindCd(C_AccessLogSyubetuKbn.REPORT);
        accessLog162.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog162);

        AT_AccessLog accessLog163= new AT_AccessLog("163");
        accessLog163.setTimeStamp(20161101000000003L);
        accessLog163.setLogKindCd(C_AccessLogSyubetuKbn.KADOU_TIME_PAST);
        accessLog163.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog163);

        AT_AccessLog accessLog164= new AT_AccessLog("164");
        accessLog164.setTimeStamp(20161101000000003L);
        accessLog164.setLogKindCd(C_AccessLogSyubetuKbn.BATCH_BEGIN);
        accessLog164.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog164);

        AT_AccessLog accessLog165= new AT_AccessLog("165");
        accessLog165.setTimeStamp(20161101000000003L);
        accessLog165.setLogKindCd(C_AccessLogSyubetuKbn.BATCH_END);
        accessLog165.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog165);

        AT_AccessLog accessLog166= new AT_AccessLog("166");
        accessLog166.setTimeStamp(20161101000000003L);
        accessLog166.setLogKindCd(C_AccessLogSyubetuKbn.FILE_READ);
        accessLog166.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog166);

        AT_AccessLog accessLog167= new AT_AccessLog("167");
        accessLog167.setTimeStamp(20161101000000003L);
        accessLog167.setLogKindCd(C_AccessLogSyubetuKbn.FILE_WRITE);
        accessLog167.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog167);

        AT_AccessLog accessLog168= new AT_AccessLog("168");
        accessLog168.setTimeStamp(20161101000000003L);
        accessLog168.setLogKindCd(C_AccessLogSyubetuKbn.FILE_MOVE);
        accessLog168.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog168);

        AT_AccessLog accessLog169= new AT_AccessLog("169");
        accessLog169.setTimeStamp(20161101000000003L);
        accessLog169.setLogKindCd(C_AccessLogSyubetuKbn.FILE_COPY);
        accessLog169.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog169);

        AT_AccessLog accessLog170= new AT_AccessLog("170");
        accessLog170.setTimeStamp(20161101000000003L);
        accessLog170.setLogKindCd(C_AccessLogSyubetuKbn.FILE_REMOVE);
        accessLog170.setSyousaiKensuu(0L);

        baseDomManager.insert(accessLog170);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        baseDomManager.delete(baseDomManager.getAllAccessLogs());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        try (ExDBResults<AT_AccessLog> exDBResults = bizDomManager.getAccessLogsBySyoriYmdFromSyoriYmdTo(20161031000000023L,20161031000000024L)){

            Assert.assertFalse(exDBResults.iterator().hasNext());
        }
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        try (ExDBResults<AT_AccessLog> exDBResults = bizDomManager.getAccessLogsBySyoriYmdFromSyoriYmdTo(20161030000000000L,20161031000000000L)){
            int iCount = 0;
            for (AT_AccessLog entity : exDBResults) {

                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("31", entity.getLogId());
                    Assert.assertEquals(C_AccessLogSyubetuKbn.ACTION_BEGIN.getValue(), entity.getLogKindCd().getValue());
                }
            }

            Assert.assertEquals(1, iCount);
        }
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        try (ExDBResults<AT_AccessLog> exDBResults = bizDomManager.getAccessLogsBySyoriYmdFromSyoriYmdTo(20161031000000000L,20161101000000002L)){
            int iCount = 0;
            for (AT_AccessLog entity : exDBResults) {

                iCount++;
                if (1 == iCount) {
                    Assert.assertEquals("63", entity.getLogId());
                    Assert.assertEquals(new Long(20161101000000000L), entity.getTimeStamp());
                    Assert.assertEquals(C_AccessLogSyubetuKbn.ACTION_BEGIN.getValue(), entity.getLogKindCd().getValue());
                }
                if (2 == iCount) {
                    Assert.assertEquals("127", entity.getLogId());
                    Assert.assertEquals(new Long(20161101000000001L), entity.getTimeStamp());
                    Assert.assertEquals(C_AccessLogSyubetuKbn.ACTION_BEGIN.getValue(), entity.getLogKindCd().getValue());
                }
                if (3 == iCount) {
                    Assert.assertEquals("95", entity.getLogId());
                    Assert.assertEquals(new Long(20161101000000002L), entity.getTimeStamp());
                    Assert.assertEquals(C_AccessLogSyubetuKbn.ACTION_BEGIN.getValue(), entity.getLogKindCd().getValue());
                }

            }
            Assert.assertEquals(3, iCount);
        }

    }

}
