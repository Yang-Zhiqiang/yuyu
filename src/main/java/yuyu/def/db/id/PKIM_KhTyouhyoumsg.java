package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KyksyaSibouUmuKbn;
import yuyu.def.classification.C_Meigihnkjiyuu;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IM_KhTyouhyoumsg;
import yuyu.def.db.mapping.GenIM_KhTyouhyoumsg;
import yuyu.def.db.meta.GenQIM_KhTyouhyoumsg;
import yuyu.def.db.meta.QIM_KhTyouhyoumsg;

/**
 * 契約保全帳票メッセージマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IM_KhTyouhyoumsg}</td><td colspan="3">契約保全帳票メッセージマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getMeigihnkjiyuu meigihnkjiyuu}</td><td>名義変更事由</td><td align="center">○</td><td align="center">V</td><td>{@link C_Meigihnkjiyuu}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyksbumu kyksbumu}</td><td>契約者死亡有無</td><td align="center">○</td><td align="center">V</td><td>{@link C_KyksyaSibouUmuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getShrumu shrumu}</td><td>支払有無区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTuityouumu tuityouumu}</td><td>追徴有無区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>tyouhyoutitle</td><td>帳票タイトル</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsouhuannaimsg1</td><td>（帳票用）送付案内メッセージ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsouhuannaimsg2</td><td>（帳票用）送付案内メッセージ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsouhuannaimsg3</td><td>（帳票用）送付案内メッセージ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsouhuannaimsg4</td><td>（帳票用）送付案内メッセージ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsouhuannaimsg5</td><td>（帳票用）送付案内メッセージ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsouhuannaimsg6</td><td>（帳票用）送付案内メッセージ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsouhuannaimsg7</td><td>（帳票用）送付案内メッセージ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsouhuannaimsg8</td><td>（帳票用）送付案内メッセージ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsouhuannaimsg9</td><td>（帳票用）送付案内メッセージ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rsouhuannaimsg10</td><td>（帳票用）送付案内メッセージ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg1</td><td>（帳票用）案内内容メッセージ１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg2</td><td>（帳票用）案内内容メッセージ２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg3</td><td>（帳票用）案内内容メッセージ３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg4</td><td>（帳票用）案内内容メッセージ４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg5</td><td>（帳票用）案内内容メッセージ５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg6</td><td>（帳票用）案内内容メッセージ６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg7</td><td>（帳票用）案内内容メッセージ７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg8</td><td>（帳票用）案内内容メッセージ８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg9</td><td>（帳票用）案内内容メッセージ９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg10</td><td>（帳票用）案内内容メッセージ１０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg11</td><td>（帳票用）案内内容メッセージ１１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg12</td><td>（帳票用）案内内容メッセージ１２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg13</td><td>（帳票用）案内内容メッセージ１３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg14</td><td>（帳票用）案内内容メッセージ１４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg15</td><td>（帳票用）案内内容メッセージ１５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg16</td><td>（帳票用）案内内容メッセージ１６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg17</td><td>（帳票用）案内内容メッセージ１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg18</td><td>（帳票用）案内内容メッセージ１８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg19</td><td>（帳票用）案内内容メッセージ１９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg20</td><td>（帳票用）案内内容メッセージ２０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg21</td><td>（帳票用）案内内容メッセージ２１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg22</td><td>（帳票用）案内内容メッセージ２２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg23</td><td>（帳票用）案内内容メッセージ２３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg24</td><td>（帳票用）案内内容メッセージ２４</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg25</td><td>（帳票用）案内内容メッセージ２５</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg26</td><td>（帳票用）案内内容メッセージ２６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg27</td><td>（帳票用）案内内容メッセージ２７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg28</td><td>（帳票用）案内内容メッセージ２８</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg29</td><td>（帳票用）案内内容メッセージ２９</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>rannainaiyoumsg30</td><td>（帳票用）案内内容メッセージ３０</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IM_KhTyouhyoumsg
 * @see     GenIM_KhTyouhyoumsg
 * @see     QIM_KhTyouhyoumsg
 * @see     GenQIM_KhTyouhyoumsg
 */
public class PKIM_KhTyouhyoumsg extends AbstractExDBPrimaryKey<IM_KhTyouhyoumsg, PKIM_KhTyouhyoumsg> {

    private static final long serialVersionUID = 1L;

    public PKIM_KhTyouhyoumsg() {
    }

    public PKIM_KhTyouhyoumsg(
        C_SyoruiCdKbn pSyoruiCd,
        C_Meigihnkjiyuu pMeigihnkjiyuu,
        C_KyksyaSibouUmuKbn pKyksbumu,
        C_UmuKbn pShrumu,
        C_UmuKbn pTuityouumu
    ) {
        syoruiCd = pSyoruiCd;
        meigihnkjiyuu = pMeigihnkjiyuu;
        kyksbumu = pKyksbumu;
        shrumu = pShrumu;
        tuityouumu = pTuityouumu;
    }

    @Transient
    @Override
    public Class<IM_KhTyouhyoumsg> getEntityClass() {
        return IM_KhTyouhyoumsg.class;
    }

    private C_SyoruiCdKbn syoruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_SyoruiCdKbn")
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }
    private C_Meigihnkjiyuu meigihnkjiyuu;

    @org.hibernate.annotations.Type(type="UserType_C_Meigihnkjiyuu")
    public C_Meigihnkjiyuu getMeigihnkjiyuu() {
        return meigihnkjiyuu;
    }

    public void setMeigihnkjiyuu(C_Meigihnkjiyuu pMeigihnkjiyuu) {
        meigihnkjiyuu = pMeigihnkjiyuu;
    }
    private C_KyksyaSibouUmuKbn kyksbumu;

    @org.hibernate.annotations.Type(type="UserType_C_KyksyaSibouUmuKbn")
    public C_KyksyaSibouUmuKbn getKyksbumu() {
        return kyksbumu;
    }

    public void setKyksbumu(C_KyksyaSibouUmuKbn pKyksbumu) {
        kyksbumu = pKyksbumu;
    }
    private C_UmuKbn shrumu;

    @org.hibernate.annotations.Type(type="UserType_C_UmuKbn")
    public C_UmuKbn getShrumu() {
        return shrumu;
    }

    public void setShrumu(C_UmuKbn pShrumu) {
        shrumu = pShrumu;
    }
    private C_UmuKbn tuityouumu;

    @org.hibernate.annotations.Type(type="UserType_C_UmuKbn")
    public C_UmuKbn getTuityouumu() {
        return tuityouumu;
    }

    public void setTuityouumu(C_UmuKbn pTuityouumu) {
        tuityouumu = pTuityouumu;
    }

}