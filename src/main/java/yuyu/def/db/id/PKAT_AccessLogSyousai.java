package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_AccessLogSyousai;
import yuyu.def.db.mapping.GenAT_AccessLogSyousai;
import yuyu.def.db.meta.GenQAT_AccessLogSyousai;
import yuyu.def.db.meta.QAT_AccessLogSyousai;

/**
 * アクセスログ詳細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_AccessLogSyousai}</td><td colspan="3">アクセスログ詳細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getLogId logId}</td><td>ログＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyousaiEdaNo syousaiEdaNo}</td><td>詳細ログ枝番号</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>logSyousaiData</td><td>ログ詳細データ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_AccessLogSyousai
 * @see     GenAT_AccessLogSyousai
 * @see     QAT_AccessLogSyousai
 * @see     GenQAT_AccessLogSyousai
 */
public class PKAT_AccessLogSyousai extends AbstractExDBPrimaryKey<AT_AccessLogSyousai, PKAT_AccessLogSyousai> {

    private static final long serialVersionUID = 1L;

    public PKAT_AccessLogSyousai() {
    }

    public PKAT_AccessLogSyousai(String pLogId, Long pSyousaiEdaNo) {
        logId = pLogId;
        syousaiEdaNo = pSyousaiEdaNo;
    }

    @Transient
    @Override
    public Class<AT_AccessLogSyousai> getEntityClass() {
        return AT_AccessLogSyousai.class;
    }

    private String logId;

    public String getLogId() {
        return logId;
    }

    public void setLogId(String pLogId) {
        logId = pLogId;
    }
    private Long syousaiEdaNo;

    public Long getSyousaiEdaNo() {
        return syousaiEdaNo;
    }

    public void setSyousaiEdaNo(Long pSyousaiEdaNo) {
        syousaiEdaNo = pSyousaiEdaNo;
    }

}