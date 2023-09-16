package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_RateNenkinD;
import yuyu.def.db.mapping.GenBM_RateNenkinD;
import yuyu.def.db.meta.GenQBM_RateNenkinD;
import yuyu.def.db.meta.QBM_RateNenkinD;

/**
 * 年金開始後Ｄレートマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RateNenkinD}</td><td colspan="3">年金開始後Ｄレートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalnenkinsisutemusyurui palnenkinsisutemusyurui}</td><td>ＰＡＬ年金システム種類</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalnenkinsyuruikigou palnenkinsyuruikigou}</td><td>ＰＡＬ年金種類記号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalnenkinkigousedaicode palnenkinkigousedaicode}</td><td>ＰＡＬ年金記号世代コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalnenkinsiharaikikan palnenkinsiharaikikan}</td><td>ＰＡＬ年金支払期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalnnknksgyoteiriritucode palnnknksgyoteiriritucode}</td><td>ＰＡＬ年金開始後予定利率コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalnnknksgjmtesuuryoucode palnnknksgjmtesuuryoucode}</td><td>ＰＡＬ年金開始後事務手数料コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPaldnendo paldnendo}</td><td>ＰＡＬＤ年度</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPaldratenaikakucode paldratenaikakucode}</td><td>ＰＡＬＤレート内定確定コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate00</td><td>年金開始後Ｄレート００</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate01</td><td>年金開始後Ｄレート０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate02</td><td>年金開始後Ｄレート０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate03</td><td>年金開始後Ｄレート０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate04</td><td>年金開始後Ｄレート０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate05</td><td>年金開始後Ｄレート０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate06</td><td>年金開始後Ｄレート０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate07</td><td>年金開始後Ｄレート０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate08</td><td>年金開始後Ｄレート０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate09</td><td>年金開始後Ｄレート０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate10</td><td>年金開始後Ｄレート１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate11</td><td>年金開始後Ｄレート１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate12</td><td>年金開始後Ｄレート１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate13</td><td>年金開始後Ｄレート１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate14</td><td>年金開始後Ｄレート１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate15</td><td>年金開始後Ｄレート１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate16</td><td>年金開始後Ｄレート１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate17</td><td>年金開始後Ｄレート１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate18</td><td>年金開始後Ｄレート１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate19</td><td>年金開始後Ｄレート１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate20</td><td>年金開始後Ｄレート２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate21</td><td>年金開始後Ｄレート２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate22</td><td>年金開始後Ｄレート２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate23</td><td>年金開始後Ｄレート２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate24</td><td>年金開始後Ｄレート２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate25</td><td>年金開始後Ｄレート２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate26</td><td>年金開始後Ｄレート２６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate27</td><td>年金開始後Ｄレート２７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate28</td><td>年金開始後Ｄレート２８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate29</td><td>年金開始後Ｄレート２９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate30</td><td>年金開始後Ｄレート３０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate31</td><td>年金開始後Ｄレート３１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate32</td><td>年金開始後Ｄレート３２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate33</td><td>年金開始後Ｄレート３３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate34</td><td>年金開始後Ｄレート３４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate35</td><td>年金開始後Ｄレート３５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate36</td><td>年金開始後Ｄレート３６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate37</td><td>年金開始後Ｄレート３７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate38</td><td>年金開始後Ｄレート３８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate39</td><td>年金開始後Ｄレート３９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate40</td><td>年金開始後Ｄレート４０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate41</td><td>年金開始後Ｄレート４１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate42</td><td>年金開始後Ｄレート４２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate43</td><td>年金開始後Ｄレート４３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate44</td><td>年金開始後Ｄレート４４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate45</td><td>年金開始後Ｄレート４５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate46</td><td>年金開始後Ｄレート４６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate47</td><td>年金開始後Ｄレート４７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate48</td><td>年金開始後Ｄレート４８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate49</td><td>年金開始後Ｄレート４９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate50</td><td>年金開始後Ｄレート５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate51</td><td>年金開始後Ｄレート５１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate52</td><td>年金開始後Ｄレート５２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate53</td><td>年金開始後Ｄレート５３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate54</td><td>年金開始後Ｄレート５４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate55</td><td>年金開始後Ｄレート５５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate56</td><td>年金開始後Ｄレート５６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate57</td><td>年金開始後Ｄレート５７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate58</td><td>年金開始後Ｄレート５８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate59</td><td>年金開始後Ｄレート５９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate60</td><td>年金開始後Ｄレート６０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate61</td><td>年金開始後Ｄレート６１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate62</td><td>年金開始後Ｄレート６２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate63</td><td>年金開始後Ｄレート６３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate64</td><td>年金開始後Ｄレート６４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate65</td><td>年金開始後Ｄレート６５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate66</td><td>年金開始後Ｄレート６６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate67</td><td>年金開始後Ｄレート６７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate68</td><td>年金開始後Ｄレート６８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate69</td><td>年金開始後Ｄレート６９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate70</td><td>年金開始後Ｄレート７０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate71</td><td>年金開始後Ｄレート７１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate72</td><td>年金開始後Ｄレート７２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate73</td><td>年金開始後Ｄレート７３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate74</td><td>年金開始後Ｄレート７４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate75</td><td>年金開始後Ｄレート７５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate76</td><td>年金開始後Ｄレート７６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate77</td><td>年金開始後Ｄレート７７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate78</td><td>年金開始後Ｄレート７８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate79</td><td>年金開始後Ｄレート７９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate80</td><td>年金開始後Ｄレート８０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate81</td><td>年金開始後Ｄレート８１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate82</td><td>年金開始後Ｄレート８２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate83</td><td>年金開始後Ｄレート８３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate84</td><td>年金開始後Ｄレート８４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate85</td><td>年金開始後Ｄレート８５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate86</td><td>年金開始後Ｄレート８６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate87</td><td>年金開始後Ｄレート８７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate88</td><td>年金開始後Ｄレート８８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate89</td><td>年金開始後Ｄレート８９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate90</td><td>年金開始後Ｄレート９０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate91</td><td>年金開始後Ｄレート９１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate92</td><td>年金開始後Ｄレート９２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate93</td><td>年金開始後Ｄレート９３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate94</td><td>年金開始後Ｄレート９４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate95</td><td>年金開始後Ｄレート９５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate96</td><td>年金開始後Ｄレート９６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate97</td><td>年金開始後Ｄレート９７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate98</td><td>年金開始後Ｄレート９８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigodrate99</td><td>年金開始後Ｄレート９９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     BM_RateNenkinD
 * @see     GenBM_RateNenkinD
 * @see     QBM_RateNenkinD
 * @see     GenQBM_RateNenkinD
 */
public class PKBM_RateNenkinD extends AbstractExDBPrimaryKey<BM_RateNenkinD, PKBM_RateNenkinD> {

    private static final long serialVersionUID = 1L;

    public PKBM_RateNenkinD() {
    }

    public PKBM_RateNenkinD(
        String pPalnenkinsisutemusyurui,
        String pPalnenkinsyuruikigou,
        String pPalnenkinkigousedaicode,
        String pPalnenkinsiharaikikan,
        String pPalnnknksgyoteiriritucode,
        String pPalnnknksgjmtesuuryoucode,
        String pPaldnendo,
        String pPaldratenaikakucode
    ) {
        palnenkinsisutemusyurui = pPalnenkinsisutemusyurui;
        palnenkinsyuruikigou = pPalnenkinsyuruikigou;
        palnenkinkigousedaicode = pPalnenkinkigousedaicode;
        palnenkinsiharaikikan = pPalnenkinsiharaikikan;
        palnnknksgyoteiriritucode = pPalnnknksgyoteiriritucode;
        palnnknksgjmtesuuryoucode = pPalnnknksgjmtesuuryoucode;
        paldnendo = pPaldnendo;
        paldratenaikakucode = pPaldratenaikakucode;
    }

    @Transient
    @Override
    public Class<BM_RateNenkinD> getEntityClass() {
        return BM_RateNenkinD.class;
    }

    private String palnenkinsisutemusyurui;

    public String getPalnenkinsisutemusyurui() {
        return palnenkinsisutemusyurui;
    }

    public void setPalnenkinsisutemusyurui(String pPalnenkinsisutemusyurui) {
        palnenkinsisutemusyurui = pPalnenkinsisutemusyurui;
    }
    private String palnenkinsyuruikigou;

    public String getPalnenkinsyuruikigou() {
        return palnenkinsyuruikigou;
    }

    public void setPalnenkinsyuruikigou(String pPalnenkinsyuruikigou) {
        palnenkinsyuruikigou = pPalnenkinsyuruikigou;
    }
    private String palnenkinkigousedaicode;

    public String getPalnenkinkigousedaicode() {
        return palnenkinkigousedaicode;
    }

    public void setPalnenkinkigousedaicode(String pPalnenkinkigousedaicode) {
        palnenkinkigousedaicode = pPalnenkinkigousedaicode;
    }
    private String palnenkinsiharaikikan;

    public String getPalnenkinsiharaikikan() {
        return palnenkinsiharaikikan;
    }

    public void setPalnenkinsiharaikikan(String pPalnenkinsiharaikikan) {
        palnenkinsiharaikikan = pPalnenkinsiharaikikan;
    }
    private String palnnknksgyoteiriritucode;

    public String getPalnnknksgyoteiriritucode() {
        return palnnknksgyoteiriritucode;
    }

    public void setPalnnknksgyoteiriritucode(String pPalnnknksgyoteiriritucode) {
        palnnknksgyoteiriritucode = pPalnnknksgyoteiriritucode;
    }
    private String palnnknksgjmtesuuryoucode;

    public String getPalnnknksgjmtesuuryoucode() {
        return palnnknksgjmtesuuryoucode;
    }

    public void setPalnnknksgjmtesuuryoucode(String pPalnnknksgjmtesuuryoucode) {
        palnnknksgjmtesuuryoucode = pPalnnknksgjmtesuuryoucode;
    }
    private String paldnendo;

    public String getPaldnendo() {
        return paldnendo;
    }

    public void setPaldnendo(String pPaldnendo) {
        paldnendo = pPaldnendo;
    }
    private String paldratenaikakucode;

    public String getPaldratenaikakucode() {
        return paldratenaikakucode;
    }

    public void setPaldratenaikakucode(String pPaldratenaikakucode) {
        paldratenaikakucode = pPaldratenaikakucode;
    }

}