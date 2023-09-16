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
import yuyu.def.db.entity.IT_DSeisanShrTysySyusei;
import yuyu.def.db.mapping.GenIT_DSeisanShrTysySyusei;
import yuyu.def.db.meta.GenQIT_DSeisanShrTysySyusei;
import yuyu.def.db.meta.QIT_DSeisanShrTysySyusei;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * Ｄ精算支払調書修正テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_DSeisanShrTysySyusei}</td><td colspan="3">Ｄ精算支払調書修正テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seisandshrymd</td><td>精算Ｄ支払年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seisand</td><td>精算Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tyouseid</td><td>調整Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_DSeisanShrTysySyusei
 * @see     GenIT_DSeisanShrTysySyusei
 * @see     QIT_DSeisanShrTysySyusei
 * @see     GenQIT_DSeisanShrTysySyusei
 */
public class PKIT_DSeisanShrTysySyusei extends AbstractExDBPrimaryKey<IT_DSeisanShrTysySyusei, PKIT_DSeisanShrTysySyusei> {

    private static final long serialVersionUID = 1L;

    public PKIT_DSeisanShrTysySyusei() {
    }

    public PKIT_DSeisanShrTysySyusei(
        String pKbnkey,
        String pSyono,
        BizDate pSyoriYmd
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        syoriYmd = pSyoriYmd;
    }

    @Transient
    @Override
    public Class<IT_DSeisanShrTysySyusei> getEntityClass() {
        return IT_DSeisanShrTysySyusei.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }

}