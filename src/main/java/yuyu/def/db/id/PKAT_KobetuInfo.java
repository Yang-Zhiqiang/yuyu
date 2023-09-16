package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AT_KobetuInfo;
import yuyu.def.db.mapping.GenAT_KobetuInfo;
import yuyu.def.db.meta.GenQAT_KobetuInfo;
import yuyu.def.db.meta.QAT_KobetuInfo;

/**
 * 個別情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_KobetuInfo}</td><td colspan="3">個別情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getUserId userId}</td><td>ユーザーＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getInfoSeqNo infoSeqNo}</td><td>情報連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiYmdFrom</td><td>表示年月日（自）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hyoujiYmdTo</td><td>表示年月日（至）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hyoujiNaiyou</td><td>表示内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>infoSikibetuId</td><td>情報識別ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_KobetuInfo
 * @see     GenAT_KobetuInfo
 * @see     QAT_KobetuInfo
 * @see     GenQAT_KobetuInfo
 */
public class PKAT_KobetuInfo extends AbstractExDBPrimaryKey<AT_KobetuInfo, PKAT_KobetuInfo> {

    private static final long serialVersionUID = 1L;

    public PKAT_KobetuInfo() {
    }

    public PKAT_KobetuInfo(String pUserId, String pInfoSeqNo) {
        userId = pUserId;
        infoSeqNo = pInfoSeqNo;
    }

    @Transient
    @Override
    public Class<AT_KobetuInfo> getEntityClass() {
        return AT_KobetuInfo.class;
    }

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String pUserId) {
        userId = pUserId;
    }
    private String infoSeqNo;

    public String getInfoSeqNo() {
        return infoSeqNo;
    }

    public void setInfoSeqNo(String pInfoSeqNo) {
        infoSeqNo = pInfoSeqNo;
    }

}