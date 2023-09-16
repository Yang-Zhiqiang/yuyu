package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_KoujyoSymKanri;
import yuyu.def.db.mapping.GenIT_KoujyoSymKanri;
import yuyu.def.db.meta.GenQIT_KoujyoSymKanri;
import yuyu.def.db.meta.QIT_KoujyoSymKanri;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 控除証明書管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KoujyoSymKanri}</td><td colspan="3">控除証明書管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getNendo nendo}</td><td>年度</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>lastsyoumeiendym</td><td>最終証明終了年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KoujyoSymKanri
 * @see     GenIT_KoujyoSymKanri
 * @see     QIT_KoujyoSymKanri
 * @see     GenQIT_KoujyoSymKanri
 */
public class PKIT_KoujyoSymKanri extends AbstractExDBPrimaryKey<IT_KoujyoSymKanri, PKIT_KoujyoSymKanri> {

    private static final long serialVersionUID = 1L;

    public PKIT_KoujyoSymKanri() {
    }

    public PKIT_KoujyoSymKanri(
        String pKbnkey,
        String pSyono,
        String pNendo
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        nendo = pNendo;
    }

    @Transient
    @Override
    public Class<IT_KoujyoSymKanri> getEntityClass() {
        return IT_KoujyoSymKanri.class;
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
    private String nendo;

    public String getNendo() {
        return nendo;
    }

    public void setNendo(String pNendo) {
        nendo = pNendo;
    }

}