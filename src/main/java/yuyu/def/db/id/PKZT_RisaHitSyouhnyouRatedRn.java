package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_RisaHitSyouhnyouRatedRn;
import yuyu.def.db.mapping.GenZT_RisaHitSyouhnyouRatedRn;
import yuyu.def.db.meta.GenQZT_RisaHitSyouhnyouRatedRn;
import yuyu.def.db.meta.QZT_RisaHitSyouhnyouRatedRn;

/**
 * 利差配当商品用Ｄレートテーブル（連） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_RisaHitSyouhnyouRatedRn}</td><td colspan="3">利差配当商品用Ｄレートテーブル（連）</td></tr>
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
 * </table>
 * @see     ZT_RisaHitSyouhnyouRatedRn
 * @see     GenZT_RisaHitSyouhnyouRatedRn
 * @see     QZT_RisaHitSyouhnyouRatedRn
 * @see     GenQZT_RisaHitSyouhnyouRatedRn
 */
public class PKZT_RisaHitSyouhnyouRatedRn extends AbstractExDBPrimaryKey<ZT_RisaHitSyouhnyouRatedRn, PKZT_RisaHitSyouhnyouRatedRn> {

    private static final long serialVersionUID = 1L;

    public PKZT_RisaHitSyouhnyouRatedRn() {
    }

    public PKZT_RisaHitSyouhnyouRatedRn(
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
    public Class<ZT_RisaHitSyouhnyouRatedRn> getEntityClass() {
        return ZT_RisaHitSyouhnyouRatedRn.class;
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