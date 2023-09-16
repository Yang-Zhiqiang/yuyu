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
import yuyu.def.db.entity.ST_SuuriyouErrJyouhou;
import yuyu.def.db.mapping.GenST_SuuriyouErrJyouhou;
import yuyu.def.db.meta.GenQST_SuuriyouErrJyouhou;
import yuyu.def.db.meta.QST_SuuriyouErrJyouhou;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 数理用エラー情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_SuuriyouErrJyouhou}</td><td colspan="3">数理用エラー情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKakutyoujobcd kakutyoujobcd}</td><td>拡張ジョブコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSuuritoukeiyouerrnaiyou suuritoukeiyouerrnaiyou}</td><td>数理統計用エラー内容</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_SuuriyouErrJyouhou
 * @see     GenST_SuuriyouErrJyouhou
 * @see     QST_SuuriyouErrJyouhou
 * @see     GenQST_SuuriyouErrJyouhou
 */
public class PKST_SuuriyouErrJyouhou extends AbstractExDBPrimaryKey<ST_SuuriyouErrJyouhou, PKST_SuuriyouErrJyouhou> {

    private static final long serialVersionUID = 1L;

    public PKST_SuuriyouErrJyouhou() {
    }

    public PKST_SuuriyouErrJyouhou(
        BizDate pSyoriYmd,
        String pKakutyoujobcd,
        String pSyono,
        String pGyoumuKousinTime,
        String pSuuritoukeiyouerrnaiyou
    ) {
        syoriYmd = pSyoriYmd;
        kakutyoujobcd = pKakutyoujobcd;
        syono = pSyono;
        gyoumuKousinTime = pGyoumuKousinTime;
        suuritoukeiyouerrnaiyou = pSuuritoukeiyouerrnaiyou;
    }

    @Transient
    @Override
    public Class<ST_SuuriyouErrJyouhou> getEntityClass() {
        return ST_SuuriyouErrJyouhou.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private String kakutyoujobcd;

    public String getKakutyoujobcd() {
        return kakutyoujobcd;
    }

    public void setKakutyoujobcd(String pKakutyoujobcd) {
        kakutyoujobcd = pKakutyoujobcd;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String gyoumuKousinTime;

    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
    private String suuritoukeiyouerrnaiyou;

    public String getSuuritoukeiyouerrnaiyou() {
        return suuritoukeiyouerrnaiyou;
    }

    public void setSuuritoukeiyouerrnaiyou(String pSuuritoukeiyouerrnaiyou) {
        suuritoukeiyouerrnaiyou = pSuuritoukeiyouerrnaiyou;
    }

}