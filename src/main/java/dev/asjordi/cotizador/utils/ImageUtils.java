package dev.asjordi.cotizador.utils;

import dev.asjordi.cotizador.models.DatosEmpresa;
import dev.asjordi.cotizador.services.DatosEmpresaService;
import dev.asjordi.cotizador.services.IServiceWithImage;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Jordi <ejordi.ayala@gmail.com>
 */
public class ImageUtils {
    
    public static ImageIcon getIcon() {
        try {
            InputStream inputStream = ImageUtils.class.getResourceAsStream("/img/whiteIcon.png");
            if (inputStream != null) return new ImageIcon(ImageIO.read(inputStream));
            else return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void getLogo(JLabel jl) {
        IServiceWithImage<DatosEmpresa> service = new DatosEmpresaService();
        try {
            DatosEmpresa de = service.getImage();
            Icon imagen = new ImageIcon(de.getLogo().getImage().getScaledInstance(jl.getWidth(), jl.getHeight(), Image.SCALE_DEFAULT));
            jl.setIcon(imagen);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static InputStream convertImageIconToInputStream(ImageIcon icon) throws IOException {
        Image image = icon.getImage();
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        bufferedImage.getGraphics().drawImage(image, 0, 0, null);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", outputStream);
        byte[] imageBytes = outputStream.toByteArray();
        InputStream inputStream = new ByteArrayInputStream(imageBytes);
        return inputStream;
    }
    
}
