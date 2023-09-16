package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.BM_RateNenkinPkisoV;
import yuyu.def.db.mapping.GenBM_RateNenkinPkisoV;
import yuyu.def.db.meta.GenQBM_RateNenkinPkisoV;
import yuyu.def.db.meta.QBM_RateNenkinPkisoV;

/**
 * 年金開始後Ｐ基礎Ｖレートマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_RateNenkinPkisoV}</td><td colspan="3">年金開始後Ｐ基礎Ｖレートマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalnenkinsisutemusyurui palnenkinsisutemusyurui}</td><td>ＰＡＬ年金システム種類</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalnenkinsyuruikigou palnenkinsyuruikigou}</td><td>ＰＡＬ年金種類記号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalnenkinkigousedaicode palnenkinkigousedaicode}</td><td>ＰＡＬ年金記号世代コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalnenkinsiharaikikan palnenkinsiharaikikan}</td><td>ＰＡＬ年金支払期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalnnknksgyoteiriritucode palnnknksgyoteiriritucode}</td><td>ＰＡＬ年金開始後予定利率コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getPalnnknksgjmtesuuryoucode palnnknksgjmtesuuryoucode}</td><td>ＰＡＬ年金開始後事務手数料コード</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate00</td><td>年金開始後Ｖレート００</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate01</td><td>年金開始後Ｖレート０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate02</td><td>年金開始後Ｖレート０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate03</td><td>年金開始後Ｖレート０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate04</td><td>年金開始後Ｖレート０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate05</td><td>年金開始後Ｖレート０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate06</td><td>年金開始後Ｖレート０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate07</td><td>年金開始後Ｖレート０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate08</td><td>年金開始後Ｖレート０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate09</td><td>年金開始後Ｖレート０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate10</td><td>年金開始後Ｖレート１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate11</td><td>年金開始後Ｖレート１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate12</td><td>年金開始後Ｖレート１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate13</td><td>年金開始後Ｖレート１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate14</td><td>年金開始後Ｖレート１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate15</td><td>年金開始後Ｖレート１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate16</td><td>年金開始後Ｖレート１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate17</td><td>年金開始後Ｖレート１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate18</td><td>年金開始後Ｖレート１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate19</td><td>年金開始後Ｖレート１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate20</td><td>年金開始後Ｖレート２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate21</td><td>年金開始後Ｖレート２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate22</td><td>年金開始後Ｖレート２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate23</td><td>年金開始後Ｖレート２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate24</td><td>年金開始後Ｖレート２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate25</td><td>年金開始後Ｖレート２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate26</td><td>年金開始後Ｖレート２６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate27</td><td>年金開始後Ｖレート２７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate28</td><td>年金開始後Ｖレート２８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate29</td><td>年金開始後Ｖレート２９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate30</td><td>年金開始後Ｖレート３０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate31</td><td>年金開始後Ｖレート３１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate32</td><td>年金開始後Ｖレート３２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate33</td><td>年金開始後Ｖレート３３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate34</td><td>年金開始後Ｖレート３４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate35</td><td>年金開始後Ｖレート３５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate36</td><td>年金開始後Ｖレート３６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate37</td><td>年金開始後Ｖレート３７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate38</td><td>年金開始後Ｖレート３８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate39</td><td>年金開始後Ｖレート３９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate40</td><td>年金開始後Ｖレート４０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate41</td><td>年金開始後Ｖレート４１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate42</td><td>年金開始後Ｖレート４２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate43</td><td>年金開始後Ｖレート４３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate44</td><td>年金開始後Ｖレート４４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate45</td><td>年金開始後Ｖレート４５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate46</td><td>年金開始後Ｖレート４６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate47</td><td>年金開始後Ｖレート４７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate48</td><td>年金開始後Ｖレート４８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate49</td><td>年金開始後Ｖレート４９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate50</td><td>年金開始後Ｖレート５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate51</td><td>年金開始後Ｖレート５１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate52</td><td>年金開始後Ｖレート５２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate53</td><td>年金開始後Ｖレート５３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate54</td><td>年金開始後Ｖレート５４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate55</td><td>年金開始後Ｖレート５５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate56</td><td>年金開始後Ｖレート５６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate57</td><td>年金開始後Ｖレート５７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate58</td><td>年金開始後Ｖレート５８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate59</td><td>年金開始後Ｖレート５９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate60</td><td>年金開始後Ｖレート６０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate61</td><td>年金開始後Ｖレート６１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate62</td><td>年金開始後Ｖレート６２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate63</td><td>年金開始後Ｖレート６３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate64</td><td>年金開始後Ｖレート６４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate65</td><td>年金開始後Ｖレート６５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate66</td><td>年金開始後Ｖレート６６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate67</td><td>年金開始後Ｖレート６７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate68</td><td>年金開始後Ｖレート６８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate69</td><td>年金開始後Ｖレート６９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate70</td><td>年金開始後Ｖレート７０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate71</td><td>年金開始後Ｖレート７１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate72</td><td>年金開始後Ｖレート７２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate73</td><td>年金開始後Ｖレート７３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate74</td><td>年金開始後Ｖレート７４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate75</td><td>年金開始後Ｖレート７５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate76</td><td>年金開始後Ｖレート７６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate77</td><td>年金開始後Ｖレート７７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate78</td><td>年金開始後Ｖレート７８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate79</td><td>年金開始後Ｖレート７９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate80</td><td>年金開始後Ｖレート８０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate81</td><td>年金開始後Ｖレート８１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate82</td><td>年金開始後Ｖレート８２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate83</td><td>年金開始後Ｖレート８３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate84</td><td>年金開始後Ｖレート８４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate85</td><td>年金開始後Ｖレート８５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate86</td><td>年金開始後Ｖレート８６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate87</td><td>年金開始後Ｖレート８７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate88</td><td>年金開始後Ｖレート８８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate89</td><td>年金開始後Ｖレート８９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate90</td><td>年金開始後Ｖレート９０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate91</td><td>年金開始後Ｖレート９１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate92</td><td>年金開始後Ｖレート９２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate93</td><td>年金開始後Ｖレート９３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate94</td><td>年金開始後Ｖレート９４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate95</td><td>年金開始後Ｖレート９５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate96</td><td>年金開始後Ｖレート９６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate97</td><td>年金開始後Ｖレート９７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate98</td><td>年金開始後Ｖレート９８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>nenkinkaisigopkisovrate99</td><td>年金開始後Ｖレート９９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     BM_RateNenkinPkisoV
 * @see     GenBM_RateNenkinPkisoV
 * @see     QBM_RateNenkinPkisoV
 * @see     GenQBM_RateNenkinPkisoV
 */
public class PKBM_RateNenkinPkisoV extends AbstractExDBPrimaryKey<BM_RateNenkinPkisoV, PKBM_RateNenkinPkisoV> {

    private static final long serialVersionUID = 1L;

    public PKBM_RateNenkinPkisoV() {
    }

    public PKBM_RateNenkinPkisoV(
        String pPalnenkinsisutemusyurui,
        String pPalnenkinsyuruikigou,
        String pPalnenkinkigousedaicode,
        String pPalnenkinsiharaikikan,
        String pPalnnknksgyoteiriritucode,
        String pPalnnknksgjmtesuuryoucode
    ) {
        palnenkinsisutemusyurui = pPalnenkinsisutemusyurui;
        palnenkinsyuruikigou = pPalnenkinsyuruikigou;
        palnenkinkigousedaicode = pPalnenkinkigousedaicode;
        palnenkinsiharaikikan = pPalnenkinsiharaikikan;
        palnnknksgyoteiriritucode = pPalnnknksgyoteiriritucode;
        palnnknksgjmtesuuryoucode = pPalnnknksgjmtesuuryoucode;
    }

    @Transient
    @Override
    public Class<BM_RateNenkinPkisoV> getEntityClass() {
        return BM_RateNenkinPkisoV.class;
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

}