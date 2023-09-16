package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_RateW;
import yuyu.def.db.mapping.GenBM_RateW;
import yuyu.def.db.meta.GenQBM_RateW;
import yuyu.def.db.meta.QBM_RateW;

/**
 * Ｗレートマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RateW}</td><td colspan="3">Ｗレートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhokensyuruikigou palhokensyuruikigou}</td><td>ＰＡＬ保険種類記号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhokensyuruikigousdicode palhokensyuruikigousdicode}</td><td>ＰＡＬ保険種類記号世代コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalyoteiriritu palyoteiriritu}</td><td>ＰＡＬ予定利率</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalpmencode palpmencode}</td><td>ＰＡＬＰ免コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalharaikomikaisuu palharaikomikaisuu}</td><td>ＰＡＬ払込回数</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhhknsei palhhknsei}</td><td>ＰＡＬ被保険者性別</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalkeiyakujihhknnen palkeiyakujihhknnen}</td><td>ＰＡＬ契約時被保険者年令</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalsaimankihyouji palsaimankihyouji}</td><td>ＰＡＬ才満期契約表示</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalhokenkikan palhokenkikan}</td><td>ＰＡＬ保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalpharaikomikikan palpharaikomikikan}</td><td>ＰＡＬＰ払込期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalannaihuyouriyuukbn palannaihuyouriyuukbn}</td><td>ＰＡＬ案内不要理由区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRatetuukasyukbn ratetuukasyukbn}</td><td>レート用通貨種類区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRatedai1hknkkn ratedai1hknkkn}</td><td>レート用第１保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>wrate00</td><td>Ｗレート００</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate01</td><td>Ｗレート０１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate02</td><td>Ｗレート０２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate03</td><td>Ｗレート０３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate04</td><td>Ｗレート０４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate05</td><td>Ｗレート０５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate06</td><td>Ｗレート０６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate07</td><td>Ｗレート０７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate08</td><td>Ｗレート０８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate09</td><td>Ｗレート０９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate10</td><td>Ｗレート１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate11</td><td>Ｗレート１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate12</td><td>Ｗレート１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate13</td><td>Ｗレート１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate14</td><td>Ｗレート１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate15</td><td>Ｗレート１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate16</td><td>Ｗレート１６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate17</td><td>Ｗレート１７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate18</td><td>Ｗレート１８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate19</td><td>Ｗレート１９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate20</td><td>Ｗレート２０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate21</td><td>Ｗレート２１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate22</td><td>Ｗレート２２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate23</td><td>Ｗレート２３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate24</td><td>Ｗレート２４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate25</td><td>Ｗレート２５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate26</td><td>Ｗレート２６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate27</td><td>Ｗレート２７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate28</td><td>Ｗレート２８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate29</td><td>Ｗレート２９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate30</td><td>Ｗレート３０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate31</td><td>Ｗレート３１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate32</td><td>Ｗレート３２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate33</td><td>Ｗレート３３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate34</td><td>Ｗレート３４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate35</td><td>Ｗレート３５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate36</td><td>Ｗレート３６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate37</td><td>Ｗレート３７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate38</td><td>Ｗレート３８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate39</td><td>Ｗレート３９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate40</td><td>Ｗレート４０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate41</td><td>Ｗレート４１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate42</td><td>Ｗレート４２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate43</td><td>Ｗレート４３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate44</td><td>Ｗレート４４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate45</td><td>Ｗレート４５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate46</td><td>Ｗレート４６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate47</td><td>Ｗレート４７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate48</td><td>Ｗレート４８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate49</td><td>Ｗレート４９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate50</td><td>Ｗレート５０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate51</td><td>Ｗレート５１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate52</td><td>Ｗレート５２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate53</td><td>Ｗレート５３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate54</td><td>Ｗレート５４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate55</td><td>Ｗレート５５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate56</td><td>Ｗレート５６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate57</td><td>Ｗレート５７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate58</td><td>Ｗレート５８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate59</td><td>Ｗレート５９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate60</td><td>Ｗレート６０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate61</td><td>Ｗレート６１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate62</td><td>Ｗレート６２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate63</td><td>Ｗレート６３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate64</td><td>Ｗレート６４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate65</td><td>Ｗレート６５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate66</td><td>Ｗレート６６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate67</td><td>Ｗレート６７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate68</td><td>Ｗレート６８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate69</td><td>Ｗレート６９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate70</td><td>Ｗレート７０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate71</td><td>Ｗレート７１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate72</td><td>Ｗレート７２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate73</td><td>Ｗレート７３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate74</td><td>Ｗレート７４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate75</td><td>Ｗレート７５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate76</td><td>Ｗレート７６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate77</td><td>Ｗレート７７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate78</td><td>Ｗレート７８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate79</td><td>Ｗレート７９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate80</td><td>Ｗレート８０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate81</td><td>Ｗレート８１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate82</td><td>Ｗレート８２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate83</td><td>Ｗレート８３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate84</td><td>Ｗレート８４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate85</td><td>Ｗレート８５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate86</td><td>Ｗレート８６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate87</td><td>Ｗレート８７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate88</td><td>Ｗレート８８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate89</td><td>Ｗレート８９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate90</td><td>Ｗレート９０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate91</td><td>Ｗレート９１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate92</td><td>Ｗレート９２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate93</td><td>Ｗレート９３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate94</td><td>Ｗレート９４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate95</td><td>Ｗレート９５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate96</td><td>Ｗレート９６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate97</td><td>Ｗレート９７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate98</td><td>Ｗレート９８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>wrate99</td><td>Ｗレート９９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_RateW
 * @see     GenBM_RateW
 * @see     QBM_RateW
 * @see     GenQBM_RateW
 */
public class PKBM_RateW extends AbstractExDBPrimaryKey<BM_RateW, PKBM_RateW> {

    private static final long serialVersionUID = 1L;

    public PKBM_RateW() {
    }

    public PKBM_RateW(
        String pPalhokensyuruikigou,
        String pPalhokensyuruikigousdicode,
        String pPalyoteiriritu,
        String pPalpmencode,
        String pPalharaikomikaisuu,
        String pPalhhknsei,
        String pPalkeiyakujihhknnen,
        String pPalsaimankihyouji,
        String pPalhokenkikan,
        String pPalpharaikomikikan,
        String pPalannaihuyouriyuukbn,
        String pRatetuukasyukbn,
        String pRatedai1hknkkn
    ) {
        palhokensyuruikigou = pPalhokensyuruikigou;
        palhokensyuruikigousdicode = pPalhokensyuruikigousdicode;
        palyoteiriritu = pPalyoteiriritu;
        palpmencode = pPalpmencode;
        palharaikomikaisuu = pPalharaikomikaisuu;
        palhhknsei = pPalhhknsei;
        palkeiyakujihhknnen = pPalkeiyakujihhknnen;
        palsaimankihyouji = pPalsaimankihyouji;
        palhokenkikan = pPalhokenkikan;
        palpharaikomikikan = pPalpharaikomikikan;
        palannaihuyouriyuukbn = pPalannaihuyouriyuukbn;
        ratetuukasyukbn = pRatetuukasyukbn;
        ratedai1hknkkn = pRatedai1hknkkn;
    }

    @Transient
    @Override
    public Class<BM_RateW> getEntityClass() {
        return BM_RateW.class;
    }

    private String palhokensyuruikigou;

    public String getPalhokensyuruikigou() {
        return palhokensyuruikigou;
    }

    public void setPalhokensyuruikigou(String pPalhokensyuruikigou) {
        palhokensyuruikigou = pPalhokensyuruikigou;
    }
    private String palhokensyuruikigousdicode;

    public String getPalhokensyuruikigousdicode() {
        return palhokensyuruikigousdicode;
    }

    public void setPalhokensyuruikigousdicode(String pPalhokensyuruikigousdicode) {
        palhokensyuruikigousdicode = pPalhokensyuruikigousdicode;
    }
    private String palyoteiriritu;

    public String getPalyoteiriritu() {
        return palyoteiriritu;
    }

    public void setPalyoteiriritu(String pPalyoteiriritu) {
        palyoteiriritu = pPalyoteiriritu;
    }
    private String palpmencode;

    public String getPalpmencode() {
        return palpmencode;
    }

    public void setPalpmencode(String pPalpmencode) {
        palpmencode = pPalpmencode;
    }
    private String palharaikomikaisuu;

    public String getPalharaikomikaisuu() {
        return palharaikomikaisuu;
    }

    public void setPalharaikomikaisuu(String pPalharaikomikaisuu) {
        palharaikomikaisuu = pPalharaikomikaisuu;
    }
    private String palhhknsei;

    public String getPalhhknsei() {
        return palhhknsei;
    }

    public void setPalhhknsei(String pPalhhknsei) {
        palhhknsei = pPalhhknsei;
    }
    private String palkeiyakujihhknnen;

    public String getPalkeiyakujihhknnen() {
        return palkeiyakujihhknnen;
    }

    public void setPalkeiyakujihhknnen(String pPalkeiyakujihhknnen) {
        palkeiyakujihhknnen = pPalkeiyakujihhknnen;
    }
    private String palsaimankihyouji;

    public String getPalsaimankihyouji() {
        return palsaimankihyouji;
    }

    public void setPalsaimankihyouji(String pPalsaimankihyouji) {
        palsaimankihyouji = pPalsaimankihyouji;
    }
    private String palhokenkikan;

    public String getPalhokenkikan() {
        return palhokenkikan;
    }

    public void setPalhokenkikan(String pPalhokenkikan) {
        palhokenkikan = pPalhokenkikan;
    }
    private String palpharaikomikikan;

    public String getPalpharaikomikikan() {
        return palpharaikomikikan;
    }

    public void setPalpharaikomikikan(String pPalpharaikomikikan) {
        palpharaikomikikan = pPalpharaikomikikan;
    }
    private String palannaihuyouriyuukbn;

    public String getPalannaihuyouriyuukbn() {
        return palannaihuyouriyuukbn;
    }

    public void setPalannaihuyouriyuukbn(String pPalannaihuyouriyuukbn) {
        palannaihuyouriyuukbn = pPalannaihuyouriyuukbn;
    }
    private String ratetuukasyukbn;

    public String getRatetuukasyukbn() {
        return ratetuukasyukbn;
    }

    public void setRatetuukasyukbn(String pRatetuukasyukbn) {
        ratetuukasyukbn = pRatetuukasyukbn;
    }
    private String ratedai1hknkkn;

    public String getRatedai1hknkkn() {
        return ratedai1hknkkn;
    }

    public void setRatedai1hknkkn(String pRatedai1hknkkn) {
        ratedai1hknkkn = pRatedai1hknkkn;
    }

}