package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import yuyu.def.db.mapping.GenJT_SateiSyouninRireki;
import yuyu.def.db.meta.GenQJT_SateiSyouninRireki;
import yuyu.def.db.meta.QJT_SateiSyouninRireki;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 査定承認履歴テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SateiSyouninRireki}</td><td colspan="3">査定承認履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSateisyouninskbtkey sateisyouninskbtkey}</td><td>査定承認識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>seikyuurirekino</td><td>請求履歴番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syorikekkakbn</td><td>処理結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorikekkaKbn C_SyorikekkaKbn}</td></tr>
 *  <tr><td>tennousakisousasyacd</td><td>転送先操作者コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hushrgeninkbn</td><td>不支払原因区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HushrGeninKbn C_HushrGeninKbn}</td></tr>
 *  <tr><td>higaitouriyuukbn</td><td>非該当理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HigaitouRiyuuKbn C_HigaitouRiyuuKbn}</td></tr>
 *  <tr><td>reportcomment</td><td>帳票用コメント</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sessyouyhkbn</td><td>折衝要否区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YouhiblnkKbn C_YouhiblnkKbn}</td></tr>
 *  <tr><td>sessyousisyacd</td><td>折衝支社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kaiketuymd</td><td>解決日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SateiSyouninRireki
 * @see     GenJT_SateiSyouninRireki
 * @see     QJT_SateiSyouninRireki
 * @see     GenQJT_SateiSyouninRireki
 */
public class PKJT_SateiSyouninRireki extends AbstractExDBPrimaryKey<JT_SateiSyouninRireki, PKJT_SateiSyouninRireki> {

    private static final long serialVersionUID = 1L;

    public PKJT_SateiSyouninRireki() {
    }

    public PKJT_SateiSyouninRireki(
        String pSkno,
        String pSyono,
        String pSateisyouninskbtkey
    ) {
        skno = pSkno;
        syono = pSyono;
        sateisyouninskbtkey = pSateisyouninskbtkey;
    }

    @Transient
    @Override
    public Class<JT_SateiSyouninRireki> getEntityClass() {
        return JT_SateiSyouninRireki.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String sateisyouninskbtkey;

    public String getSateisyouninskbtkey() {
        return sateisyouninskbtkey;
    }

    public void setSateisyouninskbtkey(String pSateisyouninskbtkey) {
        sateisyouninskbtkey = pSateisyouninskbtkey;
    }

}