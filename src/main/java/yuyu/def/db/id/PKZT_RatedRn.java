package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_RatedRn;
import yuyu.def.db.mapping.GenZT_RatedRn;
import yuyu.def.db.meta.GenQZT_RatedRn;
import yuyu.def.db.meta.QZT_RatedRn;

/**
 * Dレートテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RatedRn}</td><td colspan="3">Dレートテーブル（連）</td></tr>
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
 *  <tr bgcolor="pink"><td>{@link #getZrndnendo zrndnendo}</td><td>（連携用）Ｄ年度</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZrnnaiteikakuteikbn zrnnaiteikakuteikbn}</td><td>（連携用）Ｄレート内定確定区分</td><td align="center">○</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>zrndrate00</td><td>（連携用）Ｄレート００</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate01</td><td>（連携用）Ｄレート０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate02</td><td>（連携用）Ｄレート０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate03</td><td>（連携用）Ｄレート０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate04</td><td>（連携用）Ｄレート０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate05</td><td>（連携用）Ｄレート０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate06</td><td>（連携用）Ｄレート０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate07</td><td>（連携用）Ｄレート０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate08</td><td>（連携用）Ｄレート０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate09</td><td>（連携用）Ｄレート０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate10</td><td>（連携用）Ｄレート１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate11</td><td>（連携用）Ｄレート１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate12</td><td>（連携用）Ｄレート１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate13</td><td>（連携用）Ｄレート１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate14</td><td>（連携用）Ｄレート１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate15</td><td>（連携用）Ｄレート１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate16</td><td>（連携用）Ｄレート１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate17</td><td>（連携用）Ｄレート１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate18</td><td>（連携用）Ｄレート１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate19</td><td>（連携用）Ｄレート１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate20</td><td>（連携用）Ｄレート２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate21</td><td>（連携用）Ｄレート２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate22</td><td>（連携用）Ｄレート２２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate23</td><td>（連携用）Ｄレート２３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate24</td><td>（連携用）Ｄレート２４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate25</td><td>（連携用）Ｄレート２５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate26</td><td>（連携用）Ｄレート２６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate27</td><td>（連携用）Ｄレート２７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate28</td><td>（連携用）Ｄレート２８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate29</td><td>（連携用）Ｄレート２９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate30</td><td>（連携用）Ｄレート３０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate31</td><td>（連携用）Ｄレート３１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate32</td><td>（連携用）Ｄレート３２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate33</td><td>（連携用）Ｄレート３３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate34</td><td>（連携用）Ｄレート３４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate35</td><td>（連携用）Ｄレート３５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate36</td><td>（連携用）Ｄレート３６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate37</td><td>（連携用）Ｄレート３７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate38</td><td>（連携用）Ｄレート３８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate39</td><td>（連携用）Ｄレート３９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate40</td><td>（連携用）Ｄレート４０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate41</td><td>（連携用）Ｄレート４１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate42</td><td>（連携用）Ｄレート４２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate43</td><td>（連携用）Ｄレート４３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate44</td><td>（連携用）Ｄレート４４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate45</td><td>（連携用）Ｄレート４５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate46</td><td>（連携用）Ｄレート４６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate47</td><td>（連携用）Ｄレート４７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate48</td><td>（連携用）Ｄレート４８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate49</td><td>（連携用）Ｄレート４９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate50</td><td>（連携用）Ｄレート５０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate51</td><td>（連携用）Ｄレート５１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate52</td><td>（連携用）Ｄレート５２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate53</td><td>（連携用）Ｄレート５３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate54</td><td>（連携用）Ｄレート５４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate55</td><td>（連携用）Ｄレート５５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate56</td><td>（連携用）Ｄレート５６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate57</td><td>（連携用）Ｄレート５７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate58</td><td>（連携用）Ｄレート５８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate59</td><td>（連携用）Ｄレート５９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate60</td><td>（連携用）Ｄレート６０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate61</td><td>（連携用）Ｄレート６１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate62</td><td>（連携用）Ｄレート６２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate63</td><td>（連携用）Ｄレート６３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate64</td><td>（連携用）Ｄレート６４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate65</td><td>（連携用）Ｄレート６５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate66</td><td>（連携用）Ｄレート６６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate67</td><td>（連携用）Ｄレート６７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate68</td><td>（連携用）Ｄレート６８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate69</td><td>（連携用）Ｄレート６９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate70</td><td>（連携用）Ｄレート７０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate71</td><td>（連携用）Ｄレート７１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate72</td><td>（連携用）Ｄレート７２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate73</td><td>（連携用）Ｄレート７３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate74</td><td>（連携用）Ｄレート７４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate75</td><td>（連携用）Ｄレート７５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate76</td><td>（連携用）Ｄレート７６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate77</td><td>（連携用）Ｄレート７７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate78</td><td>（連携用）Ｄレート７８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate79</td><td>（連携用）Ｄレート７９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate80</td><td>（連携用）Ｄレート８０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate81</td><td>（連携用）Ｄレート８１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate82</td><td>（連携用）Ｄレート８２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate83</td><td>（連携用）Ｄレート８３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate84</td><td>（連携用）Ｄレート８４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate85</td><td>（連携用）Ｄレート８５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate86</td><td>（連携用）Ｄレート８６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate87</td><td>（連携用）Ｄレート８７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate88</td><td>（連携用）Ｄレート８８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate89</td><td>（連携用）Ｄレート８９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate90</td><td>（連携用）Ｄレート９０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate91</td><td>（連携用）Ｄレート９１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate92</td><td>（連携用）Ｄレート９２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate93</td><td>（連携用）Ｄレート９３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate94</td><td>（連携用）Ｄレート９４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate95</td><td>（連携用）Ｄレート９５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate96</td><td>（連携用）Ｄレート９６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate97</td><td>（連携用）Ｄレート９７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate98</td><td>（連携用）Ｄレート９８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndrate99</td><td>（連携用）Ｄレート９９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate00</td><td>（連携用）死差Ｄレート００</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate01</td><td>（連携用）死差Ｄレート０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate02</td><td>（連携用）死差Ｄレート０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate03</td><td>（連携用）死差Ｄレート０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate04</td><td>（連携用）死差Ｄレート０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate05</td><td>（連携用）死差Ｄレート０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate06</td><td>（連携用）死差Ｄレート０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate07</td><td>（連携用）死差Ｄレート０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate08</td><td>（連携用）死差Ｄレート０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate09</td><td>（連携用）死差Ｄレート０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate10</td><td>（連携用）死差Ｄレート１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate11</td><td>（連携用）死差Ｄレート１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate12</td><td>（連携用）死差Ｄレート１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate13</td><td>（連携用）死差Ｄレート１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate14</td><td>（連携用）死差Ｄレート１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate15</td><td>（連携用）死差Ｄレート１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate16</td><td>（連携用）死差Ｄレート１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate17</td><td>（連携用）死差Ｄレート１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate18</td><td>（連携用）死差Ｄレート１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate19</td><td>（連携用）死差Ｄレート１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate20</td><td>（連携用）死差Ｄレート２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate21</td><td>（連携用）死差Ｄレート２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate22</td><td>（連携用）死差Ｄレート２２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate23</td><td>（連携用）死差Ｄレート２３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate24</td><td>（連携用）死差Ｄレート２４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate25</td><td>（連携用）死差Ｄレート２５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate26</td><td>（連携用）死差Ｄレート２６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate27</td><td>（連携用）死差Ｄレート２７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate28</td><td>（連携用）死差Ｄレート２８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate29</td><td>（連携用）死差Ｄレート２９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate30</td><td>（連携用）死差Ｄレート３０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate31</td><td>（連携用）死差Ｄレート３１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate32</td><td>（連携用）死差Ｄレート３２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate33</td><td>（連携用）死差Ｄレート３３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate34</td><td>（連携用）死差Ｄレート３４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate35</td><td>（連携用）死差Ｄレート３５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate36</td><td>（連携用）死差Ｄレート３６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate37</td><td>（連携用）死差Ｄレート３７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate38</td><td>（連携用）死差Ｄレート３８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate39</td><td>（連携用）死差Ｄレート３９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate40</td><td>（連携用）死差Ｄレート４０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate41</td><td>（連携用）死差Ｄレート４１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate42</td><td>（連携用）死差Ｄレート４２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate43</td><td>（連携用）死差Ｄレート４３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate44</td><td>（連携用）死差Ｄレート４４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate45</td><td>（連携用）死差Ｄレート４５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate46</td><td>（連携用）死差Ｄレート４６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate47</td><td>（連携用）死差Ｄレート４７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate48</td><td>（連携用）死差Ｄレート４８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate49</td><td>（連携用）死差Ｄレート４９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate50</td><td>（連携用）死差Ｄレート５０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate51</td><td>（連携用）死差Ｄレート５１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate52</td><td>（連携用）死差Ｄレート５２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate53</td><td>（連携用）死差Ｄレート５３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate54</td><td>（連携用）死差Ｄレート５４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate55</td><td>（連携用）死差Ｄレート５５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate56</td><td>（連携用）死差Ｄレート５６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate57</td><td>（連携用）死差Ｄレート５７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate58</td><td>（連携用）死差Ｄレート５８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate59</td><td>（連携用）死差Ｄレート５９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate60</td><td>（連携用）死差Ｄレート６０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate61</td><td>（連携用）死差Ｄレート６１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate62</td><td>（連携用）死差Ｄレート６２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate63</td><td>（連携用）死差Ｄレート６３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate64</td><td>（連携用）死差Ｄレート６４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate65</td><td>（連携用）死差Ｄレート６５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate66</td><td>（連携用）死差Ｄレート６６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate67</td><td>（連携用）死差Ｄレート６７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate68</td><td>（連携用）死差Ｄレート６８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate69</td><td>（連携用）死差Ｄレート６９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate70</td><td>（連携用）死差Ｄレート７０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate71</td><td>（連携用）死差Ｄレート７１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate72</td><td>（連携用）死差Ｄレート７２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate73</td><td>（連携用）死差Ｄレート７３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate74</td><td>（連携用）死差Ｄレート７４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate75</td><td>（連携用）死差Ｄレート７５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate76</td><td>（連携用）死差Ｄレート７６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate77</td><td>（連携用）死差Ｄレート７７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate78</td><td>（連携用）死差Ｄレート７８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate79</td><td>（連携用）死差Ｄレート７９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate80</td><td>（連携用）死差Ｄレート８０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate81</td><td>（連携用）死差Ｄレート８１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate82</td><td>（連携用）死差Ｄレート８２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate83</td><td>（連携用）死差Ｄレート８３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate84</td><td>（連携用）死差Ｄレート８４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate85</td><td>（連携用）死差Ｄレート８５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate86</td><td>（連携用）死差Ｄレート８６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate87</td><td>（連携用）死差Ｄレート８７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate88</td><td>（連携用）死差Ｄレート８８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate89</td><td>（連携用）死差Ｄレート８９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate90</td><td>（連携用）死差Ｄレート９０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate91</td><td>（連携用）死差Ｄレート９１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate92</td><td>（連携用）死差Ｄレート９２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate93</td><td>（連携用）死差Ｄレート９３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate94</td><td>（連携用）死差Ｄレート９４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate95</td><td>（連携用）死差Ｄレート９５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate96</td><td>（連携用）死差Ｄレート９６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate97</td><td>（連携用）死差Ｄレート９７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate98</td><td>（連携用）死差Ｄレート９８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnsisadrate99</td><td>（連携用）死差Ｄレート９９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate00</td><td>（連携用）利差Ｄレート００</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate01</td><td>（連携用）利差Ｄレート０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate02</td><td>（連携用）利差Ｄレート０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate03</td><td>（連携用）利差Ｄレート０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate04</td><td>（連携用）利差Ｄレート０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate05</td><td>（連携用）利差Ｄレート０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate06</td><td>（連携用）利差Ｄレート０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate07</td><td>（連携用）利差Ｄレート０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate08</td><td>（連携用）利差Ｄレート０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate09</td><td>（連携用）利差Ｄレート０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate10</td><td>（連携用）利差Ｄレート１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate11</td><td>（連携用）利差Ｄレート１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate12</td><td>（連携用）利差Ｄレート１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate13</td><td>（連携用）利差Ｄレート１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate14</td><td>（連携用）利差Ｄレート１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate15</td><td>（連携用）利差Ｄレート１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate16</td><td>（連携用）利差Ｄレート１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate17</td><td>（連携用）利差Ｄレート１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate18</td><td>（連携用）利差Ｄレート１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate19</td><td>（連携用）利差Ｄレート１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate20</td><td>（連携用）利差Ｄレート２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate21</td><td>（連携用）利差Ｄレート２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate22</td><td>（連携用）利差Ｄレート２２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate23</td><td>（連携用）利差Ｄレート２３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate24</td><td>（連携用）利差Ｄレート２４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate25</td><td>（連携用）利差Ｄレート２５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate26</td><td>（連携用）利差Ｄレート２６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate27</td><td>（連携用）利差Ｄレート２７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate28</td><td>（連携用）利差Ｄレート２８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate29</td><td>（連携用）利差Ｄレート２９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate30</td><td>（連携用）利差Ｄレート３０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate31</td><td>（連携用）利差Ｄレート３１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate32</td><td>（連携用）利差Ｄレート３２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate33</td><td>（連携用）利差Ｄレート３３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate34</td><td>（連携用）利差Ｄレート３４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate35</td><td>（連携用）利差Ｄレート３５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate36</td><td>（連携用）利差Ｄレート３６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate37</td><td>（連携用）利差Ｄレート３７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate38</td><td>（連携用）利差Ｄレート３８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate39</td><td>（連携用）利差Ｄレート３９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate40</td><td>（連携用）利差Ｄレート４０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate41</td><td>（連携用）利差Ｄレート４１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate42</td><td>（連携用）利差Ｄレート４２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate43</td><td>（連携用）利差Ｄレート４３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate44</td><td>（連携用）利差Ｄレート４４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate45</td><td>（連携用）利差Ｄレート４５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate46</td><td>（連携用）利差Ｄレート４６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate47</td><td>（連携用）利差Ｄレート４７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate48</td><td>（連携用）利差Ｄレート４８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate49</td><td>（連携用）利差Ｄレート４９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate50</td><td>（連携用）利差Ｄレート５０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate51</td><td>（連携用）利差Ｄレート５１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate52</td><td>（連携用）利差Ｄレート５２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate53</td><td>（連携用）利差Ｄレート５３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate54</td><td>（連携用）利差Ｄレート５４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate55</td><td>（連携用）利差Ｄレート５５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate56</td><td>（連携用）利差Ｄレート５６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate57</td><td>（連携用）利差Ｄレート５７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate58</td><td>（連携用）利差Ｄレート５８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate59</td><td>（連携用）利差Ｄレート５９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate60</td><td>（連携用）利差Ｄレート６０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate61</td><td>（連携用）利差Ｄレート６１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate62</td><td>（連携用）利差Ｄレート６２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate63</td><td>（連携用）利差Ｄレート６３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate64</td><td>（連携用）利差Ｄレート６４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate65</td><td>（連携用）利差Ｄレート６５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate66</td><td>（連携用）利差Ｄレート６６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate67</td><td>（連携用）利差Ｄレート６７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate68</td><td>（連携用）利差Ｄレート６８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate69</td><td>（連携用）利差Ｄレート６９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate70</td><td>（連携用）利差Ｄレート７０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate71</td><td>（連携用）利差Ｄレート７１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate72</td><td>（連携用）利差Ｄレート７２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate73</td><td>（連携用）利差Ｄレート７３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate74</td><td>（連携用）利差Ｄレート７４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate75</td><td>（連携用）利差Ｄレート７５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate76</td><td>（連携用）利差Ｄレート７６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate77</td><td>（連携用）利差Ｄレート７７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate78</td><td>（連携用）利差Ｄレート７８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate79</td><td>（連携用）利差Ｄレート７９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate80</td><td>（連携用）利差Ｄレート８０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate81</td><td>（連携用）利差Ｄレート８１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate82</td><td>（連携用）利差Ｄレート８２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate83</td><td>（連携用）利差Ｄレート８３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate84</td><td>（連携用）利差Ｄレート８４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate85</td><td>（連携用）利差Ｄレート８５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate86</td><td>（連携用）利差Ｄレート８６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate87</td><td>（連携用）利差Ｄレート８７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate88</td><td>（連携用）利差Ｄレート８８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate89</td><td>（連携用）利差Ｄレート８９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate90</td><td>（連携用）利差Ｄレート９０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate91</td><td>（連携用）利差Ｄレート９１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate92</td><td>（連携用）利差Ｄレート９２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate93</td><td>（連携用）利差Ｄレート９３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate94</td><td>（連携用）利差Ｄレート９４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate95</td><td>（連携用）利差Ｄレート９５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate96</td><td>（連携用）利差Ｄレート９６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate97</td><td>（連携用）利差Ｄレート９７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate98</td><td>（連携用）利差Ｄレート９８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnrisadrate99</td><td>（連携用）利差Ｄレート９９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate00</td><td>（連携用）費差Ｄレート００</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate01</td><td>（連携用）費差Ｄレート０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate02</td><td>（連携用）費差Ｄレート０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate03</td><td>（連携用）費差Ｄレート０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate04</td><td>（連携用）費差Ｄレート０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate05</td><td>（連携用）費差Ｄレート０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate06</td><td>（連携用）費差Ｄレート０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate07</td><td>（連携用）費差Ｄレート０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate08</td><td>（連携用）費差Ｄレート０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate09</td><td>（連携用）費差Ｄレート０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate10</td><td>（連携用）費差Ｄレート１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate11</td><td>（連携用）費差Ｄレート１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate12</td><td>（連携用）費差Ｄレート１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate13</td><td>（連携用）費差Ｄレート１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate14</td><td>（連携用）費差Ｄレート１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate15</td><td>（連携用）費差Ｄレート１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate16</td><td>（連携用）費差Ｄレート１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate17</td><td>（連携用）費差Ｄレート１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate18</td><td>（連携用）費差Ｄレート１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate19</td><td>（連携用）費差Ｄレート１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate20</td><td>（連携用）費差Ｄレート２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate21</td><td>（連携用）費差Ｄレート２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate22</td><td>（連携用）費差Ｄレート２２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate23</td><td>（連携用）費差Ｄレート２３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate24</td><td>（連携用）費差Ｄレート２４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate25</td><td>（連携用）費差Ｄレート２５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate26</td><td>（連携用）費差Ｄレート２６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate27</td><td>（連携用）費差Ｄレート２７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate28</td><td>（連携用）費差Ｄレート２８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate29</td><td>（連携用）費差Ｄレート２９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate30</td><td>（連携用）費差Ｄレート３０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate31</td><td>（連携用）費差Ｄレート３１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate32</td><td>（連携用）費差Ｄレート３２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate33</td><td>（連携用）費差Ｄレート３３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate34</td><td>（連携用）費差Ｄレート３４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate35</td><td>（連携用）費差Ｄレート３５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate36</td><td>（連携用）費差Ｄレート３６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate37</td><td>（連携用）費差Ｄレート３７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate38</td><td>（連携用）費差Ｄレート３８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate39</td><td>（連携用）費差Ｄレート３９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate40</td><td>（連携用）費差Ｄレート４０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate41</td><td>（連携用）費差Ｄレート４１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate42</td><td>（連携用）費差Ｄレート４２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate43</td><td>（連携用）費差Ｄレート４３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate44</td><td>（連携用）費差Ｄレート４４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate45</td><td>（連携用）費差Ｄレート４５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate46</td><td>（連携用）費差Ｄレート４６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate47</td><td>（連携用）費差Ｄレート４７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate48</td><td>（連携用）費差Ｄレート４８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate49</td><td>（連携用）費差Ｄレート４９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate50</td><td>（連携用）費差Ｄレート５０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate51</td><td>（連携用）費差Ｄレート５１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate52</td><td>（連携用）費差Ｄレート５２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate53</td><td>（連携用）費差Ｄレート５３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate54</td><td>（連携用）費差Ｄレート５４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate55</td><td>（連携用）費差Ｄレート５５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate56</td><td>（連携用）費差Ｄレート５６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate57</td><td>（連携用）費差Ｄレート５７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate58</td><td>（連携用）費差Ｄレート５８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate59</td><td>（連携用）費差Ｄレート５９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate60</td><td>（連携用）費差Ｄレート６０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate61</td><td>（連携用）費差Ｄレート６１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate62</td><td>（連携用）費差Ｄレート６２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate63</td><td>（連携用）費差Ｄレート６３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate64</td><td>（連携用）費差Ｄレート６４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate65</td><td>（連携用）費差Ｄレート６５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate66</td><td>（連携用）費差Ｄレート６６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate67</td><td>（連携用）費差Ｄレート６７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate68</td><td>（連携用）費差Ｄレート６８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate69</td><td>（連携用）費差Ｄレート６９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate70</td><td>（連携用）費差Ｄレート７０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate71</td><td>（連携用）費差Ｄレート７１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate72</td><td>（連携用）費差Ｄレート７２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate73</td><td>（連携用）費差Ｄレート７３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate74</td><td>（連携用）費差Ｄレート７４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate75</td><td>（連携用）費差Ｄレート７５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate76</td><td>（連携用）費差Ｄレート７６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate77</td><td>（連携用）費差Ｄレート７７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate78</td><td>（連携用）費差Ｄレート７８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate79</td><td>（連携用）費差Ｄレート７９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate80</td><td>（連携用）費差Ｄレート８０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate81</td><td>（連携用）費差Ｄレート８１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate82</td><td>（連携用）費差Ｄレート８２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate83</td><td>（連携用）費差Ｄレート８３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate84</td><td>（連携用）費差Ｄレート８４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate85</td><td>（連携用）費差Ｄレート８５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate86</td><td>（連携用）費差Ｄレート８６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate87</td><td>（連携用）費差Ｄレート８７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate88</td><td>（連携用）費差Ｄレート８８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate89</td><td>（連携用）費差Ｄレート８９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate90</td><td>（連携用）費差Ｄレート９０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate91</td><td>（連携用）費差Ｄレート９１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate92</td><td>（連携用）費差Ｄレート９２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate93</td><td>（連携用）費差Ｄレート９３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate94</td><td>（連携用）費差Ｄレート９４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate95</td><td>（連携用）費差Ｄレート９５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate96</td><td>（連携用）費差Ｄレート９６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate97</td><td>（連携用）費差Ｄレート９７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate98</td><td>（連携用）費差Ｄレート９８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnhisadrate99</td><td>（連携用）費差Ｄレート９９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate00</td><td>（連携用）Ｄ用Ｖレート００</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate01</td><td>（連携用）Ｄ用Ｖレート０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate02</td><td>（連携用）Ｄ用Ｖレート０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate03</td><td>（連携用）Ｄ用Ｖレート０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate04</td><td>（連携用）Ｄ用Ｖレート０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate05</td><td>（連携用）Ｄ用Ｖレート０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate06</td><td>（連携用）Ｄ用Ｖレート０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate07</td><td>（連携用）Ｄ用Ｖレート０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate08</td><td>（連携用）Ｄ用Ｖレート０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate09</td><td>（連携用）Ｄ用Ｖレート０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate10</td><td>（連携用）Ｄ用Ｖレート１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate11</td><td>（連携用）Ｄ用Ｖレート１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate12</td><td>（連携用）Ｄ用Ｖレート１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate13</td><td>（連携用）Ｄ用Ｖレート１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate14</td><td>（連携用）Ｄ用Ｖレート１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate15</td><td>（連携用）Ｄ用Ｖレート１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate16</td><td>（連携用）Ｄ用Ｖレート１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate17</td><td>（連携用）Ｄ用Ｖレート１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate18</td><td>（連携用）Ｄ用Ｖレート１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate19</td><td>（連携用）Ｄ用Ｖレート１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate20</td><td>（連携用）Ｄ用Ｖレート２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate21</td><td>（連携用）Ｄ用Ｖレート２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate22</td><td>（連携用）Ｄ用Ｖレート２２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate23</td><td>（連携用）Ｄ用Ｖレート２３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate24</td><td>（連携用）Ｄ用Ｖレート２４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate25</td><td>（連携用）Ｄ用Ｖレート２５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate26</td><td>（連携用）Ｄ用Ｖレート２６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate27</td><td>（連携用）Ｄ用Ｖレート２７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate28</td><td>（連携用）Ｄ用Ｖレート２８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate29</td><td>（連携用）Ｄ用Ｖレート２９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate30</td><td>（連携用）Ｄ用Ｖレート３０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate31</td><td>（連携用）Ｄ用Ｖレート３１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate32</td><td>（連携用）Ｄ用Ｖレート３２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate33</td><td>（連携用）Ｄ用Ｖレート３３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate34</td><td>（連携用）Ｄ用Ｖレート３４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate35</td><td>（連携用）Ｄ用Ｖレート３５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate36</td><td>（連携用）Ｄ用Ｖレート３６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate37</td><td>（連携用）Ｄ用Ｖレート３７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate38</td><td>（連携用）Ｄ用Ｖレート３８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate39</td><td>（連携用）Ｄ用Ｖレート３９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate40</td><td>（連携用）Ｄ用Ｖレート４０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate41</td><td>（連携用）Ｄ用Ｖレート４１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate42</td><td>（連携用）Ｄ用Ｖレート４２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate43</td><td>（連携用）Ｄ用Ｖレート４３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate44</td><td>（連携用）Ｄ用Ｖレート４４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate45</td><td>（連携用）Ｄ用Ｖレート４５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate46</td><td>（連携用）Ｄ用Ｖレート４６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate47</td><td>（連携用）Ｄ用Ｖレート４７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate48</td><td>（連携用）Ｄ用Ｖレート４８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate49</td><td>（連携用）Ｄ用Ｖレート４９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate50</td><td>（連携用）Ｄ用Ｖレート５０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate51</td><td>（連携用）Ｄ用Ｖレート５１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate52</td><td>（連携用）Ｄ用Ｖレート５２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate53</td><td>（連携用）Ｄ用Ｖレート５３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate54</td><td>（連携用）Ｄ用Ｖレート５４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate55</td><td>（連携用）Ｄ用Ｖレート５５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate56</td><td>（連携用）Ｄ用Ｖレート５６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate57</td><td>（連携用）Ｄ用Ｖレート５７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate58</td><td>（連携用）Ｄ用Ｖレート５８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate59</td><td>（連携用）Ｄ用Ｖレート５９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate60</td><td>（連携用）Ｄ用Ｖレート６０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate61</td><td>（連携用）Ｄ用Ｖレート６１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate62</td><td>（連携用）Ｄ用Ｖレート６２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate63</td><td>（連携用）Ｄ用Ｖレート６３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate64</td><td>（連携用）Ｄ用Ｖレート６４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate65</td><td>（連携用）Ｄ用Ｖレート６５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate66</td><td>（連携用）Ｄ用Ｖレート６６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate67</td><td>（連携用）Ｄ用Ｖレート６７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate68</td><td>（連携用）Ｄ用Ｖレート６８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate69</td><td>（連携用）Ｄ用Ｖレート６９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate70</td><td>（連携用）Ｄ用Ｖレート７０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate71</td><td>（連携用）Ｄ用Ｖレート７１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate72</td><td>（連携用）Ｄ用Ｖレート７２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate73</td><td>（連携用）Ｄ用Ｖレート７３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate74</td><td>（連携用）Ｄ用Ｖレート７４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate75</td><td>（連携用）Ｄ用Ｖレート７５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate76</td><td>（連携用）Ｄ用Ｖレート７６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate77</td><td>（連携用）Ｄ用Ｖレート７７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate78</td><td>（連携用）Ｄ用Ｖレート７８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate79</td><td>（連携用）Ｄ用Ｖレート７９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate80</td><td>（連携用）Ｄ用Ｖレート８０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate81</td><td>（連携用）Ｄ用Ｖレート８１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate82</td><td>（連携用）Ｄ用Ｖレート８２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate83</td><td>（連携用）Ｄ用Ｖレート８３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate84</td><td>（連携用）Ｄ用Ｖレート８４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate85</td><td>（連携用）Ｄ用Ｖレート８５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate86</td><td>（連携用）Ｄ用Ｖレート８６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate87</td><td>（連携用）Ｄ用Ｖレート８７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate88</td><td>（連携用）Ｄ用Ｖレート８８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate89</td><td>（連携用）Ｄ用Ｖレート８９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate90</td><td>（連携用）Ｄ用Ｖレート９０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate91</td><td>（連携用）Ｄ用Ｖレート９１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate92</td><td>（連携用）Ｄ用Ｖレート９２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate93</td><td>（連携用）Ｄ用Ｖレート９３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate94</td><td>（連携用）Ｄ用Ｖレート９４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate95</td><td>（連携用）Ｄ用Ｖレート９５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate96</td><td>（連携用）Ｄ用Ｖレート９６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate97</td><td>（連携用）Ｄ用Ｖレート９７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate98</td><td>（連携用）Ｄ用Ｖレート９８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrndyouvrate99</td><td>（連携用）Ｄ用Ｖレート９９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate00</td><td>（連携用）危険Ｓレート００</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate01</td><td>（連携用）危険Ｓレート０１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate02</td><td>（連携用）危険Ｓレート０２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate03</td><td>（連携用）危険Ｓレート０３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate04</td><td>（連携用）危険Ｓレート０４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate05</td><td>（連携用）危険Ｓレート０５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate06</td><td>（連携用）危険Ｓレート０６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate07</td><td>（連携用）危険Ｓレート０７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate08</td><td>（連携用）危険Ｓレート０８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate09</td><td>（連携用）危険Ｓレート０９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate10</td><td>（連携用）危険Ｓレート１０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate11</td><td>（連携用）危険Ｓレート１１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate12</td><td>（連携用）危険Ｓレート１２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate13</td><td>（連携用）危険Ｓレート１３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate14</td><td>（連携用）危険Ｓレート１４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate15</td><td>（連携用）危険Ｓレート１５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate16</td><td>（連携用）危険Ｓレート１６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate17</td><td>（連携用）危険Ｓレート１７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate18</td><td>（連携用）危険Ｓレート１８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate19</td><td>（連携用）危険Ｓレート１９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate20</td><td>（連携用）危険Ｓレート２０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate21</td><td>（連携用）危険Ｓレート２１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate22</td><td>（連携用）危険Ｓレート２２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate23</td><td>（連携用）危険Ｓレート２３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate24</td><td>（連携用）危険Ｓレート２４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate25</td><td>（連携用）危険Ｓレート２５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate26</td><td>（連携用）危険Ｓレート２６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate27</td><td>（連携用）危険Ｓレート２７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate28</td><td>（連携用）危険Ｓレート２８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate29</td><td>（連携用）危険Ｓレート２９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate30</td><td>（連携用）危険Ｓレート３０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate31</td><td>（連携用）危険Ｓレート３１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate32</td><td>（連携用）危険Ｓレート３２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate33</td><td>（連携用）危険Ｓレート３３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate34</td><td>（連携用）危険Ｓレート３４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate35</td><td>（連携用）危険Ｓレート３５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate36</td><td>（連携用）危険Ｓレート３６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate37</td><td>（連携用）危険Ｓレート３７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate38</td><td>（連携用）危険Ｓレート３８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate39</td><td>（連携用）危険Ｓレート３９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate40</td><td>（連携用）危険Ｓレート４０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate41</td><td>（連携用）危険Ｓレート４１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate42</td><td>（連携用）危険Ｓレート４２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate43</td><td>（連携用）危険Ｓレート４３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate44</td><td>（連携用）危険Ｓレート４４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate45</td><td>（連携用）危険Ｓレート４５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate46</td><td>（連携用）危険Ｓレート４６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate47</td><td>（連携用）危険Ｓレート４７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate48</td><td>（連携用）危険Ｓレート４８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate49</td><td>（連携用）危険Ｓレート４９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate50</td><td>（連携用）危険Ｓレート５０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate51</td><td>（連携用）危険Ｓレート５１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate52</td><td>（連携用）危険Ｓレート５２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate53</td><td>（連携用）危険Ｓレート５３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate54</td><td>（連携用）危険Ｓレート５４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate55</td><td>（連携用）危険Ｓレート５５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate56</td><td>（連携用）危険Ｓレート５６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate57</td><td>（連携用）危険Ｓレート５７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate58</td><td>（連携用）危険Ｓレート５８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate59</td><td>（連携用）危険Ｓレート５９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate60</td><td>（連携用）危険Ｓレート６０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate61</td><td>（連携用）危険Ｓレート６１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate62</td><td>（連携用）危険Ｓレート６２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate63</td><td>（連携用）危険Ｓレート６３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate64</td><td>（連携用）危険Ｓレート６４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate65</td><td>（連携用）危険Ｓレート６５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate66</td><td>（連携用）危険Ｓレート６６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate67</td><td>（連携用）危険Ｓレート６７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate68</td><td>（連携用）危険Ｓレート６８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate69</td><td>（連携用）危険Ｓレート６９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate70</td><td>（連携用）危険Ｓレート７０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate71</td><td>（連携用）危険Ｓレート７１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate72</td><td>（連携用）危険Ｓレート７２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate73</td><td>（連携用）危険Ｓレート７３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate74</td><td>（連携用）危険Ｓレート７４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate75</td><td>（連携用）危険Ｓレート７５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate76</td><td>（連携用）危険Ｓレート７６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate77</td><td>（連携用）危険Ｓレート７７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate78</td><td>（連携用）危険Ｓレート７８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate79</td><td>（連携用）危険Ｓレート７９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate80</td><td>（連携用）危険Ｓレート８０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate81</td><td>（連携用）危険Ｓレート８１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate82</td><td>（連携用）危険Ｓレート８２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate83</td><td>（連携用）危険Ｓレート８３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate84</td><td>（連携用）危険Ｓレート８４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate85</td><td>（連携用）危険Ｓレート８５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate86</td><td>（連携用）危険Ｓレート８６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate87</td><td>（連携用）危険Ｓレート８７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate88</td><td>（連携用）危険Ｓレート８８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate89</td><td>（連携用）危険Ｓレート８９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate90</td><td>（連携用）危険Ｓレート９０</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate91</td><td>（連携用）危険Ｓレート９１</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate92</td><td>（連携用）危険Ｓレート９２</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate93</td><td>（連携用）危険Ｓレート９３</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate94</td><td>（連携用）危険Ｓレート９４</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate95</td><td>（連携用）危険Ｓレート９５</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate96</td><td>（連携用）危険Ｓレート９６</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate97</td><td>（連携用）危険Ｓレート９７</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate98</td><td>（連携用）危険Ｓレート９８</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 *  <tr><td>zrnkikensrate99</td><td>（連携用）危険Ｓレート９９</td><td>&nbsp;</td><td align="center">N</td><td>Double</td></tr>
 * </table>
 * @see     ZT_RatedRn
 * @see     GenZT_RatedRn
 * @see     QZT_RatedRn
 * @see     GenQZT_RatedRn
 */
public class PKZT_RatedRn extends AbstractExDBPrimaryKey<ZT_RatedRn, PKZT_RatedRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_RatedRn() {
    }

    public PKZT_RatedRn(
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
        String pZrndnendo,
        String pZrnnaiteikakuteikbn
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
        zrndnendo = pZrndnendo;
        zrnnaiteikakuteikbn = pZrnnaiteikakuteikbn;
    }

    @Transient
    @Override
    public Class<ZT_RatedRn> getEntityClass() {
        return ZT_RatedRn.class;
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