package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_RateV;
import yuyu.def.db.mapping.GenBM_RateV;
import yuyu.def.db.meta.GenQBM_RateV;
import yuyu.def.db.meta.QBM_RateV;

/**
 * Ｖレートマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RateV}</td><td colspan="3">Ｖレートマスタ</td></tr>
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
 *  <tr><td>vrate00</td><td>Ｖレート００</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate01</td><td>Ｖレート０１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate02</td><td>Ｖレート０２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate03</td><td>Ｖレート０３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate04</td><td>Ｖレート０４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate05</td><td>Ｖレート０５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate06</td><td>Ｖレート０６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate07</td><td>Ｖレート０７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate08</td><td>Ｖレート０８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate09</td><td>Ｖレート０９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate10</td><td>Ｖレート１０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate11</td><td>Ｖレート１１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate12</td><td>Ｖレート１２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate13</td><td>Ｖレート１３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate14</td><td>Ｖレート１４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate15</td><td>Ｖレート１５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate16</td><td>Ｖレート１６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate17</td><td>Ｖレート１７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate18</td><td>Ｖレート１８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate19</td><td>Ｖレート１９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate20</td><td>Ｖレート２０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate21</td><td>Ｖレート２１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate22</td><td>Ｖレート２２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate23</td><td>Ｖレート２３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate24</td><td>Ｖレート２４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate25</td><td>Ｖレート２５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate26</td><td>Ｖレート２６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate27</td><td>Ｖレート２７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate28</td><td>Ｖレート２８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate29</td><td>Ｖレート２９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate30</td><td>Ｖレート３０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate31</td><td>Ｖレート３１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate32</td><td>Ｖレート３２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate33</td><td>Ｖレート３３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate34</td><td>Ｖレート３４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate35</td><td>Ｖレート３５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate36</td><td>Ｖレート３６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate37</td><td>Ｖレート３７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate38</td><td>Ｖレート３８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate39</td><td>Ｖレート３９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate40</td><td>Ｖレート４０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate41</td><td>Ｖレート４１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate42</td><td>Ｖレート４２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate43</td><td>Ｖレート４３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate44</td><td>Ｖレート４４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate45</td><td>Ｖレート４５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate46</td><td>Ｖレート４６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate47</td><td>Ｖレート４７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate48</td><td>Ｖレート４８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate49</td><td>Ｖレート４９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate50</td><td>Ｖレート５０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate51</td><td>Ｖレート５１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate52</td><td>Ｖレート５２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate53</td><td>Ｖレート５３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate54</td><td>Ｖレート５４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate55</td><td>Ｖレート５５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate56</td><td>Ｖレート５６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate57</td><td>Ｖレート５７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate58</td><td>Ｖレート５８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate59</td><td>Ｖレート５９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate60</td><td>Ｖレート６０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate61</td><td>Ｖレート６１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate62</td><td>Ｖレート６２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate63</td><td>Ｖレート６３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate64</td><td>Ｖレート６４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate65</td><td>Ｖレート６５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate66</td><td>Ｖレート６６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate67</td><td>Ｖレート６７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate68</td><td>Ｖレート６８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate69</td><td>Ｖレート６９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate70</td><td>Ｖレート７０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate71</td><td>Ｖレート７１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate72</td><td>Ｖレート７２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate73</td><td>Ｖレート７３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate74</td><td>Ｖレート７４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate75</td><td>Ｖレート７５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate76</td><td>Ｖレート７６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate77</td><td>Ｖレート７７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate78</td><td>Ｖレート７８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate79</td><td>Ｖレート７９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate80</td><td>Ｖレート８０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate81</td><td>Ｖレート８１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate82</td><td>Ｖレート８２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate83</td><td>Ｖレート８３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate84</td><td>Ｖレート８４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate85</td><td>Ｖレート８５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate86</td><td>Ｖレート８６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate87</td><td>Ｖレート８７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate88</td><td>Ｖレート８８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate89</td><td>Ｖレート８９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate90</td><td>Ｖレート９０</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate91</td><td>Ｖレート９１</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate92</td><td>Ｖレート９２</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate93</td><td>Ｖレート９３</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate94</td><td>Ｖレート９４</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate95</td><td>Ｖレート９５</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate96</td><td>Ｖレート９６</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate97</td><td>Ｖレート９７</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate98</td><td>Ｖレート９８</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>vrate99</td><td>Ｖレート９９</td><td>&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_RateV
 * @see     GenBM_RateV
 * @see     QBM_RateV
 * @see     GenQBM_RateV
 */
public class PKBM_RateV extends AbstractExDBPrimaryKey<BM_RateV, PKBM_RateV> {

    private static final long serialVersionUID = 1L;

    public PKBM_RateV() {
    }

    public PKBM_RateV(
        String pPalhokensyuruikigou,
        String pPalhokensyuruikigousdicode,
        String pPalyoteiriritu,
        String pPalpmencode,
        String pPalharaikomikaisuu,
        String pPalhhknsei,
        String pPalkeiyakujihhknnen,
        String pPalsaimankihyouji,
        String pPalhokenkikan,
        String pPalpharaikomikikan
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
    }

    @Transient
    @Override
    public Class<BM_RateV> getEntityClass() {
        return BM_RateV.class;
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

}