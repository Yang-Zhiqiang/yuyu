package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_RatewRn;
import yuyu.def.db.mapping.GenZT_RatewRn;
import yuyu.def.db.meta.GenQZT_RatewRn;
import yuyu.def.db.meta.QZT_RatewRn;

/**
 * Ｗレートテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RatewRn}</td><td colspan="3">Ｗレートテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhknsyukigou zrnhknsyukigou}</td><td>（連携用）保険種類記号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhknsyuruikigousedaikbn zrnhknsyuruikigousedaikbn}</td><td>（連携用）保険種類記号世代区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnyoteiriritu zrnyoteiriritu}</td><td>（連携用）予定利率</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnpmenkbn zrnpmenkbn}</td><td>（連携用）Ｐ免区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhrkkaisuukbn zrnhrkkaisuukbn}</td><td>（連携用）払込回数区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhhknsei zrnhhknsei}</td><td>（連携用）被保険者性別</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnkeiyakujihhknnen zrnkeiyakujihhknnen}</td><td>（連携用）契約時被保険者年令</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnsaimnkkykhyj zrnsaimnkkykhyj}</td><td>（連携用）才満期契約表示</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnhknkkn zrnhknkkn}</td><td>（連携用）保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnphrkkikn zrnphrkkikn}</td><td>（連携用）Ｐ払込期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnannaifuyouriyuukbn zrnannaifuyouriyuukbn}</td><td>（連携用）案内不要理由区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndai1hknkkn zrndai1hknkkn}</td><td>（連携用）第１保険期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnwrate00</td><td>（連携用）Ｗレート００</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate01</td><td>（連携用）Ｗレート０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate02</td><td>（連携用）Ｗレート０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate03</td><td>（連携用）Ｗレート０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate04</td><td>（連携用）Ｗレート０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate05</td><td>（連携用）Ｗレート０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate06</td><td>（連携用）Ｗレート０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate07</td><td>（連携用）Ｗレート０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate08</td><td>（連携用）Ｗレート０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate09</td><td>（連携用）Ｗレート０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate10</td><td>（連携用）Ｗレート１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate11</td><td>（連携用）Ｗレート１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate12</td><td>（連携用）Ｗレート１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate13</td><td>（連携用）Ｗレート１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate14</td><td>（連携用）Ｗレート１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate15</td><td>（連携用）Ｗレート１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate16</td><td>（連携用）Ｗレート１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate17</td><td>（連携用）Ｗレート１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate18</td><td>（連携用）Ｗレート１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate19</td><td>（連携用）Ｗレート１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate20</td><td>（連携用）Ｗレート２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate21</td><td>（連携用）Ｗレート２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate22</td><td>（連携用）Ｗレート２２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate23</td><td>（連携用）Ｗレート２３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate24</td><td>（連携用）Ｗレート２４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate25</td><td>（連携用）Ｗレート２５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate26</td><td>（連携用）Ｗレート２６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate27</td><td>（連携用）Ｗレート２７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate28</td><td>（連携用）Ｗレート２８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate29</td><td>（連携用）Ｗレート２９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate30</td><td>（連携用）Ｗレート３０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate31</td><td>（連携用）Ｗレート３１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate32</td><td>（連携用）Ｗレート３２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate33</td><td>（連携用）Ｗレート３３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate34</td><td>（連携用）Ｗレート３４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate35</td><td>（連携用）Ｗレート３５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate36</td><td>（連携用）Ｗレート３６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate37</td><td>（連携用）Ｗレート３７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate38</td><td>（連携用）Ｗレート３８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate39</td><td>（連携用）Ｗレート３９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate40</td><td>（連携用）Ｗレート４０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate41</td><td>（連携用）Ｗレート４１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate42</td><td>（連携用）Ｗレート４２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate43</td><td>（連携用）Ｗレート４３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate44</td><td>（連携用）Ｗレート４４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate45</td><td>（連携用）Ｗレート４５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate46</td><td>（連携用）Ｗレート４６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate47</td><td>（連携用）Ｗレート４７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate48</td><td>（連携用）Ｗレート４８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate49</td><td>（連携用）Ｗレート４９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate50</td><td>（連携用）Ｗレート５０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate51</td><td>（連携用）Ｗレート５１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate52</td><td>（連携用）Ｗレート５２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate53</td><td>（連携用）Ｗレート５３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate54</td><td>（連携用）Ｗレート５４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate55</td><td>（連携用）Ｗレート５５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate56</td><td>（連携用）Ｗレート５６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate57</td><td>（連携用）Ｗレート５７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate58</td><td>（連携用）Ｗレート５８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate59</td><td>（連携用）Ｗレート５９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate60</td><td>（連携用）Ｗレート６０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate61</td><td>（連携用）Ｗレート６１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate62</td><td>（連携用）Ｗレート６２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate63</td><td>（連携用）Ｗレート６３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate64</td><td>（連携用）Ｗレート６４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate65</td><td>（連携用）Ｗレート６５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate66</td><td>（連携用）Ｗレート６６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate67</td><td>（連携用）Ｗレート６７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate68</td><td>（連携用）Ｗレート６８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate69</td><td>（連携用）Ｗレート６９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate70</td><td>（連携用）Ｗレート７０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate71</td><td>（連携用）Ｗレート７１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate72</td><td>（連携用）Ｗレート７２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate73</td><td>（連携用）Ｗレート７３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate74</td><td>（連携用）Ｗレート７４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate75</td><td>（連携用）Ｗレート７５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate76</td><td>（連携用）Ｗレート７６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate77</td><td>（連携用）Ｗレート７７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate78</td><td>（連携用）Ｗレート７８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate79</td><td>（連携用）Ｗレート７９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate80</td><td>（連携用）Ｗレート８０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate81</td><td>（連携用）Ｗレート８１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate82</td><td>（連携用）Ｗレート８２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate83</td><td>（連携用）Ｗレート８３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate84</td><td>（連携用）Ｗレート８４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate85</td><td>（連携用）Ｗレート８５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate86</td><td>（連携用）Ｗレート８６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate87</td><td>（連携用）Ｗレート８７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate88</td><td>（連携用）Ｗレート８８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate89</td><td>（連携用）Ｗレート８９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate90</td><td>（連携用）Ｗレート９０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate91</td><td>（連携用）Ｗレート９１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate92</td><td>（連携用）Ｗレート９２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate93</td><td>（連携用）Ｗレート９３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate94</td><td>（連携用）Ｗレート９４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate95</td><td>（連携用）Ｗレート９５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate96</td><td>（連携用）Ｗレート９６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate97</td><td>（連携用）Ｗレート９７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate98</td><td>（連携用）Ｗレート９８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnwrate99</td><td>（連携用）Ｗレート９９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     ZT_RatewRn
 * @see     GenZT_RatewRn
 * @see     QZT_RatewRn
 * @see     GenQZT_RatewRn
 */
public class PKZT_RatewRn extends AbstractExDBPrimaryKey<ZT_RatewRn, PKZT_RatewRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_RatewRn() {
    }

    public PKZT_RatewRn(
        String pZrnhknsyukigou,
        String pZrnhknsyuruikigousedaikbn,
        String pZrnyoteiriritu,
        String pZrnpmenkbn,
        String pZrnhrkkaisuukbn,
        String pZrnhhknsei,
        String pZrnkeiyakujihhknnen,
        String pZrnsaimnkkykhyj,
        String pZrnhknkkn,
        String pZrnphrkkikn,
        String pZrnannaifuyouriyuukbn,
        String pZrntuukasyukbn,
        String pZrndai1hknkkn
    ) {
        zrnhknsyukigou = pZrnhknsyukigou;
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
        zrnyoteiriritu = pZrnyoteiriritu;
        zrnpmenkbn = pZrnpmenkbn;
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
        zrnhhknsei = pZrnhhknsei;
        zrnkeiyakujihhknnen = pZrnkeiyakujihhknnen;
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
        zrnhknkkn = pZrnhknkkn;
        zrnphrkkikn = pZrnphrkkikn;
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
        zrntuukasyukbn = pZrntuukasyukbn;
        zrndai1hknkkn = pZrndai1hknkkn;
    }

    @Transient
    @Override
    public Class<ZT_RatewRn> getEntityClass() {
        return ZT_RatewRn.class;
    }

    private String zrnhknsyukigou;

    public String getZrnhknsyukigou() {
        return zrnhknsyukigou;
    }

    public void setZrnhknsyukigou(String pZrnhknsyukigou) {
        zrnhknsyukigou = pZrnhknsyukigou;
    }
    private String zrnhknsyuruikigousedaikbn;

    public String getZrnhknsyuruikigousedaikbn() {
        return zrnhknsyuruikigousedaikbn;
    }

    public void setZrnhknsyuruikigousedaikbn(String pZrnhknsyuruikigousedaikbn) {
        zrnhknsyuruikigousedaikbn = pZrnhknsyuruikigousedaikbn;
    }
    private String zrnyoteiriritu;

    public String getZrnyoteiriritu() {
        return zrnyoteiriritu;
    }

    public void setZrnyoteiriritu(String pZrnyoteiriritu) {
        zrnyoteiriritu = pZrnyoteiriritu;
    }
    private String zrnpmenkbn;

    public String getZrnpmenkbn() {
        return zrnpmenkbn;
    }

    public void setZrnpmenkbn(String pZrnpmenkbn) {
        zrnpmenkbn = pZrnpmenkbn;
    }
    private String zrnhrkkaisuukbn;

    public String getZrnhrkkaisuukbn() {
        return zrnhrkkaisuukbn;
    }

    public void setZrnhrkkaisuukbn(String pZrnhrkkaisuukbn) {
        zrnhrkkaisuukbn = pZrnhrkkaisuukbn;
    }
    private String zrnhhknsei;

    public String getZrnhhknsei() {
        return zrnhhknsei;
    }

    public void setZrnhhknsei(String pZrnhhknsei) {
        zrnhhknsei = pZrnhhknsei;
    }
    private String zrnkeiyakujihhknnen;

    public String getZrnkeiyakujihhknnen() {
        return zrnkeiyakujihhknnen;
    }

    public void setZrnkeiyakujihhknnen(String pZrnkeiyakujihhknnen) {
        zrnkeiyakujihhknnen = pZrnkeiyakujihhknnen;
    }
    private String zrnsaimnkkykhyj;

    public String getZrnsaimnkkykhyj() {
        return zrnsaimnkkykhyj;
    }

    public void setZrnsaimnkkykhyj(String pZrnsaimnkkykhyj) {
        zrnsaimnkkykhyj = pZrnsaimnkkykhyj;
    }
    private String zrnhknkkn;

    public String getZrnhknkkn() {
        return zrnhknkkn;
    }

    public void setZrnhknkkn(String pZrnhknkkn) {
        zrnhknkkn = pZrnhknkkn;
    }
    private String zrnphrkkikn;

    public String getZrnphrkkikn() {
        return zrnphrkkikn;
    }

    public void setZrnphrkkikn(String pZrnphrkkikn) {
        zrnphrkkikn = pZrnphrkkikn;
    }
    private String zrnannaifuyouriyuukbn;

    public String getZrnannaifuyouriyuukbn() {
        return zrnannaifuyouriyuukbn;
    }

    public void setZrnannaifuyouriyuukbn(String pZrnannaifuyouriyuukbn) {
        zrnannaifuyouriyuukbn = pZrnannaifuyouriyuukbn;
    }
    private String zrntuukasyukbn;

    public String getZrntuukasyukbn() {
        return zrntuukasyukbn;
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        zrntuukasyukbn = pZrntuukasyukbn;
    }
    private String zrndai1hknkkn;

    public String getZrndai1hknkkn() {
        return zrndai1hknkkn;
    }

    public void setZrndai1hknkkn(String pZrndai1hknkkn) {
        zrndai1hknkkn = pZrndai1hknkkn;
    }

}