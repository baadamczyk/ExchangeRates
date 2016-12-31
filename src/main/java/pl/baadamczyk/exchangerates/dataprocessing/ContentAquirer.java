package pl.baadamczyk.exchangerates.dataprocessing;

import org.w3c.dom.NodeList;

/**
 *
 * @author baadamczyk
 */
interface ContentAquirer {
    void aquireContent(NodeList SourceNodeList);
}
