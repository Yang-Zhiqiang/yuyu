package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_RatevRn;
import yuyu.def.db.mapping.GenZT_RatevRn;
import yuyu.def.db.meta.GenQZT_RatevRn;
import yuyu.def.db.meta.QZT_RatevRn;

/**
 * Ｖレートテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RatevRn}</td><td colspan="3">Ｖレートテーブル（連）</td></tr>
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
 *  <tr><td>zrnvrate00</td><td>（連携用）Ｖレート００</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate01</td><td>（連携用）Ｖレート０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate02</td><td>（連携用）Ｖレート０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate03</td><td>（連携用）Ｖレート０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate04</td><td>（連携用）Ｖレート０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate05</td><td>（連携用）Ｖレート０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate06</td><td>（連携用）Ｖレート０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate07</td><td>（連携用）Ｖレート０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate08</td><td>（連携用）Ｖレート０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate09</td><td>（連携用）Ｖレート０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate10</td><td>（連携用）Ｖレート１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate11</td><td>（連携用）Ｖレート１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate12</td><td>（連携用）Ｖレート１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate13</td><td>（連携用）Ｖレート１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate14</td><td>（連携用）Ｖレート１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate15</td><td>（連携用）Ｖレート１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate16</td><td>（連携用）Ｖレート１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate17</td><td>（連携用）Ｖレート１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate18</td><td>（連携用）Ｖレート１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate19</td><td>（連携用）Ｖレート１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate20</td><td>（連携用）Ｖレート２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate21</td><td>（連携用）Ｖレート２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate22</td><td>（連携用）Ｖレート２２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate23</td><td>（連携用）Ｖレート２３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate24</td><td>（連携用）Ｖレート２４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate25</td><td>（連携用）Ｖレート２５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate26</td><td>（連携用）Ｖレート２６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate27</td><td>（連携用）Ｖレート２７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate28</td><td>（連携用）Ｖレート２８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate29</td><td>（連携用）Ｖレート２９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate30</td><td>（連携用）Ｖレート３０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate31</td><td>（連携用）Ｖレート３１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate32</td><td>（連携用）Ｖレート３２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate33</td><td>（連携用）Ｖレート３３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate34</td><td>（連携用）Ｖレート３４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate35</td><td>（連携用）Ｖレート３５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate36</td><td>（連携用）Ｖレート３６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate37</td><td>（連携用）Ｖレート３７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate38</td><td>（連携用）Ｖレート３８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate39</td><td>（連携用）Ｖレート３９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate40</td><td>（連携用）Ｖレート４０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate41</td><td>（連携用）Ｖレート４１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate42</td><td>（連携用）Ｖレート４２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate43</td><td>（連携用）Ｖレート４３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate44</td><td>（連携用）Ｖレート４４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate45</td><td>（連携用）Ｖレート４５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate46</td><td>（連携用）Ｖレート４６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate47</td><td>（連携用）Ｖレート４７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate48</td><td>（連携用）Ｖレート４８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate49</td><td>（連携用）Ｖレート４９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate50</td><td>（連携用）Ｖレート５０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate51</td><td>（連携用）Ｖレート５１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate52</td><td>（連携用）Ｖレート５２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate53</td><td>（連携用）Ｖレート５３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate54</td><td>（連携用）Ｖレート５４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate55</td><td>（連携用）Ｖレート５５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate56</td><td>（連携用）Ｖレート５６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate57</td><td>（連携用）Ｖレート５７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate58</td><td>（連携用）Ｖレート５８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate59</td><td>（連携用）Ｖレート５９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate60</td><td>（連携用）Ｖレート６０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate61</td><td>（連携用）Ｖレート６１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate62</td><td>（連携用）Ｖレート６２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate63</td><td>（連携用）Ｖレート６３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate64</td><td>（連携用）Ｖレート６４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate65</td><td>（連携用）Ｖレート６５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate66</td><td>（連携用）Ｖレート６６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate67</td><td>（連携用）Ｖレート６７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate68</td><td>（連携用）Ｖレート６８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate69</td><td>（連携用）Ｖレート６９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate70</td><td>（連携用）Ｖレート７０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate71</td><td>（連携用）Ｖレート７１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate72</td><td>（連携用）Ｖレート７２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate73</td><td>（連携用）Ｖレート７３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate74</td><td>（連携用）Ｖレート７４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate75</td><td>（連携用）Ｖレート７５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate76</td><td>（連携用）Ｖレート７６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate77</td><td>（連携用）Ｖレート７７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate78</td><td>（連携用）Ｖレート７８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate79</td><td>（連携用）Ｖレート７９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate80</td><td>（連携用）Ｖレート８０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate81</td><td>（連携用）Ｖレート８１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate82</td><td>（連携用）Ｖレート８２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate83</td><td>（連携用）Ｖレート８３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate84</td><td>（連携用）Ｖレート８４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate85</td><td>（連携用）Ｖレート８５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate86</td><td>（連携用）Ｖレート８６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate87</td><td>（連携用）Ｖレート８７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate88</td><td>（連携用）Ｖレート８８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate89</td><td>（連携用）Ｖレート８９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate90</td><td>（連携用）Ｖレート９０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate91</td><td>（連携用）Ｖレート９１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate92</td><td>（連携用）Ｖレート９２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate93</td><td>（連携用）Ｖレート９３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate94</td><td>（連携用）Ｖレート９４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate95</td><td>（連携用）Ｖレート９５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate96</td><td>（連携用）Ｖレート９６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate97</td><td>（連携用）Ｖレート９７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate98</td><td>（連携用）Ｖレート９８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnvrate99</td><td>（連携用）Ｖレート９９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     ZT_RatevRn
 * @see     GenZT_RatevRn
 * @see     QZT_RatevRn
 * @see     GenQZT_RatevRn
 */
public class PKZT_RatevRn extends AbstractExDBPrimaryKey<ZT_RatevRn, PKZT_RatevRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_RatevRn() {
    }

    public PKZT_RatevRn(
        String pZrnhknsyukigou,
        String pZrnhknsyuruikigousedaikbn,
        String pZrnyoteiriritu,
        String pZrnpmenkbn,
        String pZrnhrkkaisuukbn,
        String pZrnhhknsei,
        String pZrnkeiyakujihhknnen,
        String pZrnsaimnkkykhyj,
        String pZrnhknkkn,
        String pZrnphrkkikn
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
    }

    @Transient
    @Override
    public Class<ZT_RatevRn> getEntityClass() {
        return ZT_RatevRn.class;
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

}