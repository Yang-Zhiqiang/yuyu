package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_NennkinRatedRn;
import yuyu.def.db.mapping.GenZT_NennkinRatedRn;
import yuyu.def.db.meta.GenQZT_NennkinRatedRn;
import yuyu.def.db.meta.QZT_NennkinRatedRn;

/**
 * 年金開始後Ｄレートテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_NennkinRatedRn}</td><td colspan="3">年金開始後Ｄレートテーブル（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnenkinkbn zrnnenkinkbn}</td><td>（連携用）年金区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnenkinsyu zrnnenkinsyu}</td><td>（連携用）年金種類記号</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnenkinkigousedaikbn zrnnenkinkigousedaikbn}</td><td>（連携用）年金記号世代区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnknshry zrnnknshry}</td><td>（連携用）年金支払期間</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnkkaisigoyoteiriritukbn zrnnkkaisigoyoteiriritukbn}</td><td>（連携用）年金開始後予定利率区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnenkinjimutesuuryoukbn zrnnenkinjimutesuuryoukbn}</td><td>（連携用）年金事務手数料区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrndnendo zrndnendo}</td><td>（連携用）Ｄ年度</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnaiteikakuteikbn zrnnaiteikakuteikbn}</td><td>（連携用）Ｄレート内定確定区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate00</td><td>（連携用）年金開始後Ｄレート００</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate01</td><td>（連携用）年金開始後Ｄレート０１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate02</td><td>（連携用）年金開始後Ｄレート０２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate03</td><td>（連携用）年金開始後Ｄレート０３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate04</td><td>（連携用）年金開始後Ｄレート０４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate05</td><td>（連携用）年金開始後Ｄレート０５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate06</td><td>（連携用）年金開始後Ｄレート０６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate07</td><td>（連携用）年金開始後Ｄレート０７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate08</td><td>（連携用）年金開始後Ｄレート０８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate09</td><td>（連携用）年金開始後Ｄレート０９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate10</td><td>（連携用）年金開始後Ｄレート１０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate11</td><td>（連携用）年金開始後Ｄレート１１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate12</td><td>（連携用）年金開始後Ｄレート１２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate13</td><td>（連携用）年金開始後Ｄレート１３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate14</td><td>（連携用）年金開始後Ｄレート１４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate15</td><td>（連携用）年金開始後Ｄレート１５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate16</td><td>（連携用）年金開始後Ｄレート１６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate17</td><td>（連携用）年金開始後Ｄレート１７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate18</td><td>（連携用）年金開始後Ｄレート１８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate19</td><td>（連携用）年金開始後Ｄレート１９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate20</td><td>（連携用）年金開始後Ｄレート２０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate21</td><td>（連携用）年金開始後Ｄレート２１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate22</td><td>（連携用）年金開始後Ｄレート２２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate23</td><td>（連携用）年金開始後Ｄレート２３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate24</td><td>（連携用）年金開始後Ｄレート２４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate25</td><td>（連携用）年金開始後Ｄレート２５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate26</td><td>（連携用）年金開始後Ｄレート２６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate27</td><td>（連携用）年金開始後Ｄレート２７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate28</td><td>（連携用）年金開始後Ｄレート２８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate29</td><td>（連携用）年金開始後Ｄレート２９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate30</td><td>（連携用）年金開始後Ｄレート３０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate31</td><td>（連携用）年金開始後Ｄレート３１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate32</td><td>（連携用）年金開始後Ｄレート３２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate33</td><td>（連携用）年金開始後Ｄレート３３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate34</td><td>（連携用）年金開始後Ｄレート３４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate35</td><td>（連携用）年金開始後Ｄレート３５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate36</td><td>（連携用）年金開始後Ｄレート３６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate37</td><td>（連携用）年金開始後Ｄレート３７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate38</td><td>（連携用）年金開始後Ｄレート３８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate39</td><td>（連携用）年金開始後Ｄレート３９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate40</td><td>（連携用）年金開始後Ｄレート４０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate41</td><td>（連携用）年金開始後Ｄレート４１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate42</td><td>（連携用）年金開始後Ｄレート４２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate43</td><td>（連携用）年金開始後Ｄレート４３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate44</td><td>（連携用）年金開始後Ｄレート４４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate45</td><td>（連携用）年金開始後Ｄレート４５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate46</td><td>（連携用）年金開始後Ｄレート４６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate47</td><td>（連携用）年金開始後Ｄレート４７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate48</td><td>（連携用）年金開始後Ｄレート４８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate49</td><td>（連携用）年金開始後Ｄレート４９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate50</td><td>（連携用）年金開始後Ｄレート５０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate51</td><td>（連携用）年金開始後Ｄレート５１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate52</td><td>（連携用）年金開始後Ｄレート５２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate53</td><td>（連携用）年金開始後Ｄレート５３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate54</td><td>（連携用）年金開始後Ｄレート５４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate55</td><td>（連携用）年金開始後Ｄレート５５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate56</td><td>（連携用）年金開始後Ｄレート５６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate57</td><td>（連携用）年金開始後Ｄレート５７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate58</td><td>（連携用）年金開始後Ｄレート５８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate59</td><td>（連携用）年金開始後Ｄレート５９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate60</td><td>（連携用）年金開始後Ｄレート６０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate61</td><td>（連携用）年金開始後Ｄレート６１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate62</td><td>（連携用）年金開始後Ｄレート６２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate63</td><td>（連携用）年金開始後Ｄレート６３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate64</td><td>（連携用）年金開始後Ｄレート６４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate65</td><td>（連携用）年金開始後Ｄレート６５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate66</td><td>（連携用）年金開始後Ｄレート６６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate67</td><td>（連携用）年金開始後Ｄレート６７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate68</td><td>（連携用）年金開始後Ｄレート６８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate69</td><td>（連携用）年金開始後Ｄレート６９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate70</td><td>（連携用）年金開始後Ｄレート７０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate71</td><td>（連携用）年金開始後Ｄレート７１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate72</td><td>（連携用）年金開始後Ｄレート７２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate73</td><td>（連携用）年金開始後Ｄレート７３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate74</td><td>（連携用）年金開始後Ｄレート７４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate75</td><td>（連携用）年金開始後Ｄレート７５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate76</td><td>（連携用）年金開始後Ｄレート７６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate77</td><td>（連携用）年金開始後Ｄレート７７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate78</td><td>（連携用）年金開始後Ｄレート７８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate79</td><td>（連携用）年金開始後Ｄレート７９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate80</td><td>（連携用）年金開始後Ｄレート８０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate81</td><td>（連携用）年金開始後Ｄレート８１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate82</td><td>（連携用）年金開始後Ｄレート８２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate83</td><td>（連携用）年金開始後Ｄレート８３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate84</td><td>（連携用）年金開始後Ｄレート８４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate85</td><td>（連携用）年金開始後Ｄレート８５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate86</td><td>（連携用）年金開始後Ｄレート８６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate87</td><td>（連携用）年金開始後Ｄレート８７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate88</td><td>（連携用）年金開始後Ｄレート８８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate89</td><td>（連携用）年金開始後Ｄレート８９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate90</td><td>（連携用）年金開始後Ｄレート９０</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate91</td><td>（連携用）年金開始後Ｄレート９１</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate92</td><td>（連携用）年金開始後Ｄレート９２</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate93</td><td>（連携用）年金開始後Ｄレート９３</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate94</td><td>（連携用）年金開始後Ｄレート９４</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate95</td><td>（連携用）年金開始後Ｄレート９５</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate96</td><td>（連携用）年金開始後Ｄレート９６</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate97</td><td>（連携用）年金開始後Ｄレート９７</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate98</td><td>（連携用）年金開始後Ｄレート９８</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrnnenkinkaisigodrate99</td><td>（連携用）年金開始後Ｄレート９９</td><td>&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_NennkinRatedRn
 * @see     GenZT_NennkinRatedRn
 * @see     QZT_NennkinRatedRn
 * @see     GenQZT_NennkinRatedRn
 */
public class PKZT_NennkinRatedRn extends AbstractExDBPrimaryKey<ZT_NennkinRatedRn, PKZT_NennkinRatedRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_NennkinRatedRn() {
    }

    public PKZT_NennkinRatedRn(
        String pZrnnenkinkbn,
        String pZrnnenkinsyu,
        String pZrnnenkinkigousedaikbn,
        String pZrnnknshry,
        String pZrnnkkaisigoyoteiriritukbn,
        String pZrnnenkinjimutesuuryoukbn,
        String pZrndnendo,
        String pZrnnaiteikakuteikbn
    ) {
        zrnnenkinkbn = pZrnnenkinkbn;
        zrnnenkinsyu = pZrnnenkinsyu;
        zrnnenkinkigousedaikbn = pZrnnenkinkigousedaikbn;
        zrnnknshry = pZrnnknshry;
        zrnnkkaisigoyoteiriritukbn = pZrnnkkaisigoyoteiriritukbn;
        zrnnenkinjimutesuuryoukbn = pZrnnenkinjimutesuuryoukbn;
        zrndnendo = pZrndnendo;
        zrnnaiteikakuteikbn = pZrnnaiteikakuteikbn;
    }

    @Transient
    @Override
    public Class<ZT_NennkinRatedRn> getEntityClass() {
        return ZT_NennkinRatedRn.class;
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
    private String zrndnendo;

    public String getZrndnendo() {
        return zrndnendo;
    }

    public void setZrndnendo(String pZrndnendo) {
        zrndnendo = pZrndnendo;
    }
    private String zrnnaiteikakuteikbn;

    public String getZrnnaiteikakuteikbn() {
        return zrnnaiteikakuteikbn;
    }

    public void setZrnnaiteikakuteikbn(String pZrnnaiteikakuteikbn) {
        zrnnaiteikakuteikbn = pZrnnaiteikakuteikbn;
    }

}