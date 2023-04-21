package tk.devmello.mellolib.math.controllers.control1D;

import tk.devmello.mellolib.math.controllers.AbstractController;
import tk.devmello.mellolib.util.java.StringUtils;
import tk.devmello.mellolib.util.misc.ValidationUtils;

public class ProportionalController extends AbstractController {
    private final double coefficient;
    public ProportionalController(double coefficient) {
        ValidationUtils.validate(coefficient, "coefficient");
        this.coefficient = coefficient;
    }


    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public double calculate(double value) {
        ValidationUtils.validate(value, "value");
        double delta = getTarget() - value;
        return clip(delta * coefficient);
    }

    @Override
    public String toString() {
        double min = getMin();
        double max = getMax();

        String minString = Double.isInfinite(min)
                ? ""
                : StringUtils.concat(" min: ", StringUtils.wrap(min));
        String maxString = Double.isInfinite(min)
                ? ""
                : StringUtils.concat(" max: ", StringUtils.wrap(max));

        return StringUtils.format(
                "ProportionalController (coeff: <%s> target: <%s>%s%s)",
                coefficient,
                getTarget(),
                minString,
                maxString
        );
    }
}
