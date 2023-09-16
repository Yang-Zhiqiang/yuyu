package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.Range;
import yuyu.def.db.entity.BM_IkkatuKeisuu;
import yuyu.def.db.mapping.GenBM_IkkatuKeisuu;
import yuyu.def.db.meta.GenQBM_IkkatuKeisuu;
import yuyu.def.db.meta.QBM_IkkatuKeisuu;

/**
 * 一括払係数マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_IkkatuKeisuu}</td><td colspan="3">一括払係数マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getIkttekiyouno ikttekiyouno}</td><td>一括払適用番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getNen1nen2baraihyouji nen1nen2baraihyouji}</td><td>年１回年２回払表示</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKeikatukisuu keikatukisuu}</td><td>経過月数（２桁）</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>iktkeisuu</td><td>一括払係数</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_IkkatuKeisuu
 * @see     GenBM_IkkatuKeisuu
 * @see     QBM_IkkatuKeisuu
 * @see     GenQBM_IkkatuKeisuu
 */
public class PKBM_IkkatuKeisuu extends AbstractExDBPrimaryKey<BM_IkkatuKeisuu, PKBM_IkkatuKeisuu> {

    private static final long serialVersionUID = 1L;

    public PKBM_IkkatuKeisuu() {
    }

    public PKBM_IkkatuKeisuu(
        Integer pIkttekiyouno,
        Integer pNen1nen2baraihyouji,
        Integer pKeikatukisuu
    ) {
        ikttekiyouno = pIkttekiyouno;
        nen1nen2baraihyouji = pNen1nen2baraihyouji;
        keikatukisuu = pKeikatukisuu;
    }

    @Transient
    @Override
    public Class<BM_IkkatuKeisuu> getEntityClass() {
        return BM_IkkatuKeisuu.class;
    }

    private Integer ikttekiyouno;

    public Integer getIkttekiyouno() {
        return ikttekiyouno;
    }

    public void setIkttekiyouno(Integer pIkttekiyouno) {
        ikttekiyouno = pIkttekiyouno;
    }
    private Integer nen1nen2baraihyouji;

    public Integer getNen1nen2baraihyouji() {
        return nen1nen2baraihyouji;
    }

    public void setNen1nen2baraihyouji(Integer pNen1nen2baraihyouji) {
        nen1nen2baraihyouji = pNen1nen2baraihyouji;
    }
    private Integer keikatukisuu;

    public Integer getKeikatukisuu() {
        return keikatukisuu;
    }

    public void setKeikatukisuu(Integer pKeikatukisuu) {
        keikatukisuu = pKeikatukisuu;
    }

}