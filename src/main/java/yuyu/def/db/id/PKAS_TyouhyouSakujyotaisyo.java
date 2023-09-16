package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AS_TyouhyouSakujyotaisyo;
import yuyu.def.db.mapping.GenAS_TyouhyouSakujyotaisyo;
import yuyu.def.db.meta.GenQAS_TyouhyouSakujyotaisyo;
import yuyu.def.db.meta.QAS_TyouhyouSakujyotaisyo;

/**
 * 帳票削除対象基幹テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_TyouhyouSakujyotaisyo}</td><td colspan="3">帳票削除対象基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>hozonKikan</td><td>保存期間</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nengetukbn</td><td>年月区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NengetuKbn C_NengetuKbn}</td></tr>
 * </table>
 * @see     AS_TyouhyouSakujyotaisyo
 * @see     GenAS_TyouhyouSakujyotaisyo
 * @see     QAS_TyouhyouSakujyotaisyo
 * @see     GenQAS_TyouhyouSakujyotaisyo
 */
public class PKAS_TyouhyouSakujyotaisyo extends AbstractExDBPrimaryKey<AS_TyouhyouSakujyotaisyo, PKAS_TyouhyouSakujyotaisyo> {

    private static final long serialVersionUID = 1L;

    public PKAS_TyouhyouSakujyotaisyo() {
    }

    public PKAS_TyouhyouSakujyotaisyo(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    @Transient
    @Override
    public Class<AS_TyouhyouSakujyotaisyo> getEntityClass() {
        return AS_TyouhyouSakujyotaisyo.class;
    }

    private C_SyoruiCdKbn syoruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_SyoruiCdKbn")
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

}