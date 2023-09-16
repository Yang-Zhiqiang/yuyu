package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.BM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.mapping.GenBM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.meta.GenQBM_SyoruiZokuseiHukaInfo;
import yuyu.def.db.meta.QBM_SyoruiZokuseiHukaInfo;

/**
 * 書類属性付加情報マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SyoruiZokuseiHukaInfo}</td><td colspan="3">書類属性付加情報マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>subSystemId</td><td>サブシステムＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tyouhyououtkinousiyouumu</td><td>帳票出力機能使用有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 * </table>
 * @see     BM_SyoruiZokuseiHukaInfo
 * @see     GenBM_SyoruiZokuseiHukaInfo
 * @see     QBM_SyoruiZokuseiHukaInfo
 * @see     GenQBM_SyoruiZokuseiHukaInfo
 */
public class PKBM_SyoruiZokuseiHukaInfo extends AbstractExDBPrimaryKey<BM_SyoruiZokuseiHukaInfo, PKBM_SyoruiZokuseiHukaInfo> {

    private static final long serialVersionUID = 1L;

    public PKBM_SyoruiZokuseiHukaInfo() {
    }

    public PKBM_SyoruiZokuseiHukaInfo(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    @Transient
    @Override
    public Class<BM_SyoruiZokuseiHukaInfo> getEntityClass() {
        return BM_SyoruiZokuseiHukaInfo.class;
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