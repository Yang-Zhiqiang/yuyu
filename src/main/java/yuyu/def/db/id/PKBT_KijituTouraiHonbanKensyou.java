package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BT_KijituTouraiHonbanKensyou;
import yuyu.def.db.mapping.GenBT_KijituTouraiHonbanKensyou;
import yuyu.def.db.meta.GenQBT_KijituTouraiHonbanKensyou;
import yuyu.def.db.meta.QBT_KijituTouraiHonbanKensyou;

/**
 * 期日到来本番検証用テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_KijituTouraiHonbanKensyou}</td><td colspan="3">期日到来本番検証用テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTysytno tysytno}</td><td>抽出番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDatakanrino datakanrino}</td><td>データ管理番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tysytnaiyou1</td><td>抽出内容１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tysytnaiyou2</td><td>抽出内容２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tysytnaiyou3</td><td>抽出内容３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tysytnaiyou4</td><td>抽出内容４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tysytnaiyou5</td><td>抽出内容５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tysytnaiyou6</td><td>抽出内容６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tysytnaiyou7</td><td>抽出内容７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tysytnaiyou8</td><td>抽出内容８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tysytnaiyou9</td><td>抽出内容９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tysytnaiyou10</td><td>抽出内容１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_KijituTouraiHonbanKensyou
 * @see     GenBT_KijituTouraiHonbanKensyou
 * @see     QBT_KijituTouraiHonbanKensyou
 * @see     GenQBT_KijituTouraiHonbanKensyou
 */
public class PKBT_KijituTouraiHonbanKensyou extends AbstractExDBPrimaryKey<BT_KijituTouraiHonbanKensyou, PKBT_KijituTouraiHonbanKensyou> {

    private static final long serialVersionUID = 1L;

    public PKBT_KijituTouraiHonbanKensyou() {
    }

    public PKBT_KijituTouraiHonbanKensyou(
        BizDate pSyoriYmd,
        String pSubSystemId,
        Integer pTysytno,
        String pDatakanrino
    ) {
        syoriYmd = pSyoriYmd;
        subSystemId = pSubSystemId;
        tysytno = pTysytno;
        datakanrino = pDatakanrino;
    }

    @Transient
    @Override
    public Class<BT_KijituTouraiHonbanKensyou> getEntityClass() {
        return BT_KijituTouraiHonbanKensyou.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }
    private Integer tysytno;

    public Integer getTysytno() {
        return tysytno;
    }

    public void setTysytno(Integer pTysytno) {
        tysytno = pTysytno;
    }
    private String datakanrino;

    public String getDatakanrino() {
        return datakanrino;
    }

    public void setDatakanrino(String pDatakanrino) {
        datakanrino = pDatakanrino;
    }

}