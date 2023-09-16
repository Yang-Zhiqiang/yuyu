package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_NennkinRatepkisovRn;
import yuyu.def.db.mapping.GenZT_NennkinRatepkisovRn;
import yuyu.def.db.meta.GenQZT_NennkinRatepkisovRn;
import yuyu.def.db.meta.QZT_NennkinRatepkisovRn;

/**
 * 年金開始後Ｐ基礎Ｖレートテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NennkinRatepkisovRn}</td><td colspan="3">年金開始後Ｐ基礎Ｖレートテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnenkinkbn zrnnenkinkbn}</td><td>（連携用）年金区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnenkinsyu zrnnenkinsyu}</td><td>（連携用）年金種類記号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnenkinkigousedaikbn zrnnenkinkigousedaikbn}</td><td>（連携用）年金記号世代区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnkkaisigoyoteiriritukbn zrnnkkaisigoyoteiriritukbn}</td><td>（連携用）年金開始後予定利率区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnenkinjimutesuuryoukbn zrnnenkinjimutesuuryoukbn}</td><td>（連携用）年金事務手数料区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate00</td><td>（連携用）年金開始後Ｖレート００</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate01</td><td>（連携用）年金開始後Ｖレート０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate02</td><td>（連携用）年金開始後Ｖレート０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate03</td><td>（連携用）年金開始後Ｖレート０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate04</td><td>（連携用）年金開始後Ｖレート０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate05</td><td>（連携用）年金開始後Ｖレート０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate06</td><td>（連携用）年金開始後Ｖレート０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate07</td><td>（連携用）年金開始後Ｖレート０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate08</td><td>（連携用）年金開始後Ｖレート０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate09</td><td>（連携用）年金開始後Ｖレート０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate10</td><td>（連携用）年金開始後Ｖレート１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate11</td><td>（連携用）年金開始後Ｖレート１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate12</td><td>（連携用）年金開始後Ｖレート１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate13</td><td>（連携用）年金開始後Ｖレート１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate14</td><td>（連携用）年金開始後Ｖレート１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate15</td><td>（連携用）年金開始後Ｖレート１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate16</td><td>（連携用）年金開始後Ｖレート１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate17</td><td>（連携用）年金開始後Ｖレート１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate18</td><td>（連携用）年金開始後Ｖレート１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate19</td><td>（連携用）年金開始後Ｖレート１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate20</td><td>（連携用）年金開始後Ｖレート２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate21</td><td>（連携用）年金開始後Ｖレート２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate22</td><td>（連携用）年金開始後Ｖレート２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate23</td><td>（連携用）年金開始後Ｖレート２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate24</td><td>（連携用）年金開始後Ｖレート２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate25</td><td>（連携用）年金開始後Ｖレート２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate26</td><td>（連携用）年金開始後Ｖレート２６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate27</td><td>（連携用）年金開始後Ｖレート２７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate28</td><td>（連携用）年金開始後Ｖレート２８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate29</td><td>（連携用）年金開始後Ｖレート２９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate30</td><td>（連携用）年金開始後Ｖレート３０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate31</td><td>（連携用）年金開始後Ｖレート３１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate32</td><td>（連携用）年金開始後Ｖレート３２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate33</td><td>（連携用）年金開始後Ｖレート３３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate34</td><td>（連携用）年金開始後Ｖレート３４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate35</td><td>（連携用）年金開始後Ｖレート３５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate36</td><td>（連携用）年金開始後Ｖレート３６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate37</td><td>（連携用）年金開始後Ｖレート３７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate38</td><td>（連携用）年金開始後Ｖレート３８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate39</td><td>（連携用）年金開始後Ｖレート３９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate40</td><td>（連携用）年金開始後Ｖレート４０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate41</td><td>（連携用）年金開始後Ｖレート４１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate42</td><td>（連携用）年金開始後Ｖレート４２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate43</td><td>（連携用）年金開始後Ｖレート４３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate44</td><td>（連携用）年金開始後Ｖレート４４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate45</td><td>（連携用）年金開始後Ｖレート４５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate46</td><td>（連携用）年金開始後Ｖレート４６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate47</td><td>（連携用）年金開始後Ｖレート４７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate48</td><td>（連携用）年金開始後Ｖレート４８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate49</td><td>（連携用）年金開始後Ｖレート４９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate50</td><td>（連携用）年金開始後Ｖレート５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate51</td><td>（連携用）年金開始後Ｖレート５１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate52</td><td>（連携用）年金開始後Ｖレート５２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate53</td><td>（連携用）年金開始後Ｖレート５３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate54</td><td>（連携用）年金開始後Ｖレート５４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate55</td><td>（連携用）年金開始後Ｖレート５５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate56</td><td>（連携用）年金開始後Ｖレート５６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate57</td><td>（連携用）年金開始後Ｖレート５７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate58</td><td>（連携用）年金開始後Ｖレート５８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate59</td><td>（連携用）年金開始後Ｖレート５９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate60</td><td>（連携用）年金開始後Ｖレート６０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate61</td><td>（連携用）年金開始後Ｖレート６１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate62</td><td>（連携用）年金開始後Ｖレート６２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate63</td><td>（連携用）年金開始後Ｖレート６３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate64</td><td>（連携用）年金開始後Ｖレート６４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate65</td><td>（連携用）年金開始後Ｖレート６５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate66</td><td>（連携用）年金開始後Ｖレート６６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate67</td><td>（連携用）年金開始後Ｖレート６７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate68</td><td>（連携用）年金開始後Ｖレート６８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate69</td><td>（連携用）年金開始後Ｖレート６９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate70</td><td>（連携用）年金開始後Ｖレート７０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate71</td><td>（連携用）年金開始後Ｖレート７１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate72</td><td>（連携用）年金開始後Ｖレート７２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate73</td><td>（連携用）年金開始後Ｖレート７３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate74</td><td>（連携用）年金開始後Ｖレート７４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate75</td><td>（連携用）年金開始後Ｖレート７５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate76</td><td>（連携用）年金開始後Ｖレート７６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate77</td><td>（連携用）年金開始後Ｖレート７７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate78</td><td>（連携用）年金開始後Ｖレート７８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate79</td><td>（連携用）年金開始後Ｖレート７９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate80</td><td>（連携用）年金開始後Ｖレート８０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate81</td><td>（連携用）年金開始後Ｖレート８１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate82</td><td>（連携用）年金開始後Ｖレート８２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate83</td><td>（連携用）年金開始後Ｖレート８３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate84</td><td>（連携用）年金開始後Ｖレート８４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate85</td><td>（連携用）年金開始後Ｖレート８５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate86</td><td>（連携用）年金開始後Ｖレート８６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate87</td><td>（連携用）年金開始後Ｖレート８７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate88</td><td>（連携用）年金開始後Ｖレート８８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate89</td><td>（連携用）年金開始後Ｖレート８９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate90</td><td>（連携用）年金開始後Ｖレート９０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate91</td><td>（連携用）年金開始後Ｖレート９１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate92</td><td>（連携用）年金開始後Ｖレート９２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate93</td><td>（連携用）年金開始後Ｖレート９３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate94</td><td>（連携用）年金開始後Ｖレート９４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate95</td><td>（連携用）年金開始後Ｖレート９５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate96</td><td>（連携用）年金開始後Ｖレート９６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate97</td><td>（連携用）年金開始後Ｖレート９７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate98</td><td>（連携用）年金開始後Ｖレート９８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnkkaisigopkisovrate99</td><td>（連携用）年金開始後Ｖレート９９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NennkinRatepkisovRn
 * @see     GenZT_NennkinRatepkisovRn
 * @see     QZT_NennkinRatepkisovRn
 * @see     GenQZT_NennkinRatepkisovRn
 */
public class PKZT_NennkinRatepkisovRn extends AbstractExDBPrimaryKey<ZT_NennkinRatepkisovRn, PKZT_NennkinRatepkisovRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_NennkinRatepkisovRn() {
    }

    public PKZT_NennkinRatepkisovRn(
        String pZrnnenkinkbn,
        String pZrnnenkinsyu,
        String pZrnnenkinkigousedaikbn,
        String pZrnnknshry,
        String pZrnnkkaisigoyoteiriritukbn,
        String pZrnnenkinjimutesuuryoukbn
    ) {
        zrnnenkinkbn = pZrnnenkinkbn;
        zrnnenkinsyu = pZrnnenkinsyu;
        zrnnenkinkigousedaikbn = pZrnnenkinkigousedaikbn;
        zrnnknshry = pZrnnknshry;
        zrnnkkaisigoyoteiriritukbn = pZrnnkkaisigoyoteiriritukbn;
        zrnnenkinjimutesuuryoukbn = pZrnnenkinjimutesuuryoukbn;
    }

    @Transient
    @Override
    public Class<ZT_NennkinRatepkisovRn> getEntityClass() {
        return ZT_NennkinRatepkisovRn.class;
    }

    private String zrnnenkinkbn;

    public String getZrnnenkinkbn() {
        return zrnnenkinkbn;
    }

    public void setZrnnenkinkbn(String pZrnnenkinkbn) {
        zrnnenkinkbn = pZrnnenkinkbn;
    }
    private String zrnnenkinsyu;

    public String getZrnnenkinsyu() {
        return zrnnenkinsyu;
    }

    public void setZrnnenkinsyu(String pZrnnenkinsyu) {
        zrnnenkinsyu = pZrnnenkinsyu;
    }
    private String zrnnenkinkigousedaikbn;

    public String getZrnnenkinkigousedaikbn() {
        return zrnnenkinkigousedaikbn;
    }

    public void setZrnnenkinkigousedaikbn(String pZrnnenkinkigousedaikbn) {
        zrnnenkinkigousedaikbn = pZrnnenkinkigousedaikbn;
    }
    private String zrnnknshry;

    public String getZrnnknshry() {
        return zrnnknshry;
    }

    public void setZrnnknshry(String pZrnnknshry) {
        zrnnknshry = pZrnnknshry;
    }
    private String zrnnkkaisigoyoteiriritukbn;

    public String getZrnnkkaisigoyoteiriritukbn() {
        return zrnnkkaisigoyoteiriritukbn;
    }

    public void setZrnnkkaisigoyoteiriritukbn(String pZrnnkkaisigoyoteiriritukbn) {
        zrnnkkaisigoyoteiriritukbn = pZrnnkkaisigoyoteiriritukbn;
    }
    private String zrnnenkinjimutesuuryoukbn;

    public String getZrnnenkinjimutesuuryoukbn() {
        return zrnnenkinjimutesuuryoukbn;
    }

    public void setZrnnenkinjimutesuuryoukbn(String pZrnnenkinjimutesuuryoukbn) {
        zrnnenkinjimutesuuryoukbn = pZrnnenkinjimutesuuryoukbn;
    }

}