package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.AT_KyoutuuInfo;
import yuyu.def.db.mapping.GenAT_KyoutuuInfo;
import yuyu.def.db.meta.GenQAT_KyoutuuInfo;
import yuyu.def.db.meta.QAT_KyoutuuInfo;

/**
 * 共通情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_KyoutuuInfo}</td><td colspan="3">共通情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>subSystemId</td><td>サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>categoryId</td><td>カテゴリＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKinouId kinouId}</td><td>機能ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getInfoSeqNo infoSeqNo}</td><td>情報連番</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hyoujiYmdFrom</td><td>表示年月日（自）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hyoujiYmdTo</td><td>表示年月日（至）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hyoujiNaiyou</td><td>表示内容</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>infoSikibetuId</td><td>情報識別ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_KyoutuuInfo
 * @see     GenAT_KyoutuuInfo
 * @see     QAT_KyoutuuInfo
 * @see     GenQAT_KyoutuuInfo
 */
public class PKAT_KyoutuuInfo extends AbstractExDBPrimaryKey<AT_KyoutuuInfo, PKAT_KyoutuuInfo> {

    private static final long serialVersionUID = 1L;

    public PKAT_KyoutuuInfo() {
    }

    public PKAT_KyoutuuInfo(String pKinouId, String pInfoSeqNo) {
        kinouId = pKinouId;
        infoSeqNo = pInfoSeqNo;
    }

    @Transient
    @Override
    public Class<AT_KyoutuuInfo> getEntityClass() {
        return AT_KyoutuuInfo.class;
    }

    private String kinouId;

    public String getKinouId() {
        return kinouId;
    }

    public void setKinouId(String pKinouId) {
        kinouId = pKinouId;
    }
    private String infoSeqNo;

    public String getInfoSeqNo() {
        return infoSeqNo;
    }

    public void setInfoSeqNo(String pInfoSeqNo) {
        infoSeqNo = pInfoSeqNo;
    }

}